package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.demo.entity.Driver;
import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.mapper.DriverMapper;
import spring.demo.demo.repository.DriverRepository;
import spring.demo.demo.security.JWTUtils;

@Service
public class MeServiceImpl implements MeService {
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private DriverRepository driverRepository;

    public MeServiceImpl(JWTUtils jwtUtils, DriverRepository driverRepository) {
        this.jwtUtils = jwtUtils;
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverDto getProfile() {
        String phone = this.jwtUtils.extractUsername(
                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwODk4OTg5ODk4IiwiaWF0IjoxNzA4NTA2MTEyLCJleHAiOjE3MDg1OTI1MTJ9.s5oW33W7QcdwW9dOpm9PyYl_JKq4pfvq2B5O-HS-22fZcZNWUzwFXdxefk5PWGDyKqcbeZTB4QLR6MWumNlfeA");
        Driver driver = this.driverRepository.findByPhone(phone).orElse(null);
        return DriverMapper.toDriverDto(driver);
    }

}
