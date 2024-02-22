package spring.demo.demo.services;

import org.springframework.stereotype.Service;

import spring.demo.demo.model.dto.DriverDto;

@Service
public interface MeService {
    public DriverDto getProfile();
}
