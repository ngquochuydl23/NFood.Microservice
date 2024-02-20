package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import spring.demo.demo.entity.Driver;
import spring.demo.demo.entity.DriverLicense;
import spring.demo.demo.entity.Vehicle;
import spring.demo.demo.model.dto.AuthResponseDTO;
import spring.demo.demo.model.dto.SignInDto;
import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.mapper.DriverLicenseMapper;
import spring.demo.demo.model.mapper.DriverMapper;
import spring.demo.demo.model.mapper.VehicleMapper;
import spring.demo.demo.repository.DriverLicenseRepository;
import spring.demo.demo.repository.DriverRepository;
import spring.demo.demo.repository.VehicleRepository;
import spring.demo.demo.security.CustomUserService;
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
    private final AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtils;

    public AuthServiceImpl(DriverRepository driverRepository, DriverLicenseRepository driverLicenseRepository,
            VehicleRepository vehicleRepository, AuthenticationManager authenticationManager,
            JWTUtils jwtUtils) {
        this.driverRepository = driverRepository;
        this.driverLicenseRepository = driverLicenseRepository;
        this.vehicleRepository = vehicleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public AuthResponseDTO signIn(SignInDto signInDto) throws Exception {
        AuthResponseDTO response = new AuthResponseDTO();

        // Authentication authentication = authenticationManager.authenticate(
        // new UsernamePasswordAuthenticationToken(signInDto.getPhone(),
        // signInDto.getPassword()));

        Driver driver = driverRepository.findByPhone(signInDto.getPhone()).orElseThrow(() -> new Exception("Deo tim thay =))"));

        if (!BCrypt.checkpw(signInDto.getPassword(), driver.getPassword())) {
            throw new Exception("Sai cmn mat khau");
        }

        String jwt = jwtUtils.generateToken(driver);

        response.setAccessToken(jwt);
        return response;
    }

    @Override
    @Transactional
    public int signUp(SignUpDto signUpDto) {
        if (this.driverRepository.existsByPhone(signUpDto.getPhone())) {
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

            this.vehicleRepository.save(vehicle);
            this.driverLicenseRepository.save(driverLicense);
            this.driverRepository.save(driver);
            return HttpStatus.OK.value();
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST.value();
        }
    }

}
