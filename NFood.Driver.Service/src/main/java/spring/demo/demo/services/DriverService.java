package spring.demo.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import spring.demo.demo.entity.Driver;
import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.dto.DriverLicenseDto;
import spring.demo.demo.model.dto.VehicleDto;

@Service
public interface DriverService {
    public List<DriverDto> getDrivers();

    public Driver addNewDriver();

    public DriverDto getDriverById(long id);

    public VehicleDto getVehicleByDriverId(long id);

    public DriverLicenseDto getDriverLicenseByDriverId(long id);

}
