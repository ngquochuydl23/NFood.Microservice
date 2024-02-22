package spring.demo.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo.demo.entity.Driver;
import spring.demo.demo.entity.DriverLicense;
import spring.demo.demo.entity.Vehicle;
import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.dto.DriverLicenseDto;
import spring.demo.demo.model.dto.VehicleDto;
import spring.demo.demo.model.mapper.DriverLicenseMapper;
import spring.demo.demo.model.mapper.DriverMapper;
import spring.demo.demo.model.mapper.VehicleMapper;
import spring.demo.demo.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {
    private List<Driver> drivers = new ArrayList<Driver>();

    @Autowired
    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public List<DriverDto> getDrivers() {
        List<DriverDto> rs = new ArrayList<DriverDto>();
        for (Driver driver : this.drivers) {
            rs.add(DriverMapper.toDriverDto(driver));
        }
        return rs;
    }

    @Override
    public Driver addNewDriver() {
        // String firstName
        return null;
    }

    @Override
    public DriverDto getDriverById(long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        return driver != null ? DriverMapper.toDriverDto(driver) : null;
    }

    @Override
    public VehicleDto getVehicleByDriverId(long id) {
        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver == null)
            return null;

        Vehicle vehicle = driver.getLicensePlates();

        if (vehicle == null)
            return null;

        return VehicleMapper.toVehicleDto(vehicle);
    }

    @Override
    public DriverLicenseDto getDriverLicenseByDriverId(long id) {
        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver == null)
            return null;

        DriverLicense driverLicense = driver.getNumberDriverLicense();

        if (driverLicense == null)
            return null;

        return DriverLicenseMapper.toDriverLicenseDto(driverLicense);
    }

}
