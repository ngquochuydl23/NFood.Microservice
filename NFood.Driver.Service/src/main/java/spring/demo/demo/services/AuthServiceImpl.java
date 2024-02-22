package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import spring.demo.demo.entity.Driver;
import spring.demo.demo.entity.DriverLicense;
import spring.demo.demo.entity.Vehicle;
import spring.demo.demo.model.dto.AuthResponseDto;
import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.dto.SignInDto;
import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.mapper.DriverLicenseMapper;
import spring.demo.demo.model.mapper.DriverMapper;
import spring.demo.demo.model.mapper.VehicleMapper;
import spring.demo.demo.repository.DriverLicenseRepository;
import spring.demo.demo.repository.DriverRepository;
import spring.demo.demo.repository.VehicleRepository;
import spring.demo.demo.security.JWTUtils;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private final DriverRepository driverRepository;

    @Autowired
    private final DriverLicenseRepository driverLicenseRepository;

    @Autowired
    private final VehicleRepository vehicleRepository;

    @Autowired
    private JWTUtils jwtUtils;

    public AuthServiceImpl(DriverRepository driverRepository, DriverLicenseRepository driverLicenseRepository,
            VehicleRepository vehicleRepository,
            JWTUtils jwtUtils) {
        this.driverRepository = driverRepository;
        this.driverLicenseRepository = driverLicenseRepository;
        this.vehicleRepository = vehicleRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public AuthResponseDto signIn(SignInDto signInDto) {
        AuthResponseDto response = new AuthResponseDto();
        HttpStatus status = authenticateUser(signInDto);

        if (status != HttpStatus.OK) {
            response.setAccessToken(null);
            response.setMessage(getErrorMessage(status));
            response.setStatusCode(status.value());
            response.setResult(null);
        } else {
            Driver driver = driverRepository.findByPhone(signInDto.getPhone()).orElse(null);
            String jwt = this.jwtUtils.generateToken(driver);
            DriverDto driverDto = DriverMapper.toDriverDto(driver);

            response.setAccessToken(jwt);
            response.setMessage("Sign in success");
            response.setStatusCode(HttpStatus.OK.value());
            response.setResult(driverDto);
        }

        return response;
    }

    private HttpStatus authenticateUser(SignInDto signInDto) {
        Driver driver = driverRepository.findByPhone(signInDto.getPhone()).orElse(null);

        if (driver == null) {
            return HttpStatus.NOT_FOUND;
        }

        return BCrypt.checkpw(signInDto.getPassword(), driver.getPassword()) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
    }

    private String getErrorMessage(HttpStatus status) {
        switch (status) {
            case NOT_FOUND:
                return "User not found";
            case UNAUTHORIZED:
                return "Wrong password";
            default:
                return "Unknown error";
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int signUp(SignUpDto signUpDto) throws Exception {
        if (driverRepository.existsByPhone(signUpDto.getPhone())) {
            return HttpStatus.CONFLICT.value();
        }

        try {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encryptPwd = bCryptPasswordEncoder.encode(signUpDto.getPassword());
            signUpDto.setPassword(encryptPwd);

            Vehicle vehicle = VehicleMapper.toVehicleEntity(signUpDto);
            DriverLicense driverLicense = DriverLicenseMapper.toDriverLicenseEntity(signUpDto);
            Driver driver = DriverMapper.toDriverEntity(signUpDto);

            driver.setLicensePlates(vehicle);
            driver.setNumberDriverLicense(driverLicense);

            vehicleRepository.save(vehicle);
            driverLicenseRepository.save(driverLicense);
            driverRepository.save(driver);

            return HttpStatus.OK.value();
        } catch (Exception e) {
            throw new Exception("Error in sign up", e);
        }
    }

}
