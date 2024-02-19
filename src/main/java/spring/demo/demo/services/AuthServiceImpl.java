package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import spring.demo.demo.entity.Driver;
import spring.demo.demo.entity.DriverLicense;
import spring.demo.demo.entity.Vehicle;
import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.mapper.DriverLicenseMapper;
import spring.demo.demo.model.mapper.DriverMapper;
import spring.demo.demo.model.mapper.VehicleMapper;
import spring.demo.demo.repository.DriverLicenseRepository;
import spring.demo.demo.repository.DriverRepository;
import spring.demo.demo.repository.VehicleRepository;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private final DriverRepository driverRepository;

    @Autowired
    private final DriverLicenseRepository driverLicenseRepository;

    @Autowired
    private final VehicleRepository vehicleRepository;

    public AuthServiceImpl(DriverRepository driverRepository, DriverLicenseRepository driverLicenseRepository,
            VehicleRepository vehicleRepository) {
        this.driverRepository = driverRepository;
        this.driverLicenseRepository = driverLicenseRepository;
        this.vehicleRepository = vehicleRepository;
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
