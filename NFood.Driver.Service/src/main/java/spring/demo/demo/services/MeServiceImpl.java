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
    public DriverDto getProfile(String token) {
        String phone = this.jwtUtils.extractUsername(token);
        Driver driver = this.driverRepository.findByPhone(phone).orElse(null);
        return DriverMapper.toDriverDto(driver);
    }

}
