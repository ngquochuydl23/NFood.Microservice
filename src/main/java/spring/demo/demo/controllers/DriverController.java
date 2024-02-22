package spring.demo.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.dto.DriverLicenseDto;
import spring.demo.demo.model.dto.VehicleDto;
import spring.demo.demo.services.DriverServiceImpl;

@RestController
@RequestMapping("/driver-api/driver")
public class DriverController {
    @Autowired
    private DriverServiceImpl driverServiceImpl;

    @GetMapping("")
    public ResponseEntity<List<DriverDto>> getAllDrivers() {
        List<DriverDto> users = driverServiceImpl.getDrivers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable long id) {
        DriverDto driverDto = this.driverServiceImpl.getDriverById(id);
        return driverDto != null ? ResponseEntity.ok(driverDto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/vehicle")
    public ResponseEntity<VehicleDto> getVehicleByDriverId(@PathVariable long id) {
        VehicleDto vehicleDto = this.driverServiceImpl.getVehicleByDriverId(id);
        return vehicleDto != null ? ResponseEntity.ok(vehicleDto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/driver-license")
    public ResponseEntity<DriverLicenseDto> getDriverLicenseByDriverId(@PathVariable long id) {
        DriverLicenseDto driverLicense = this.driverServiceImpl.getDriverLicenseByDriverId(id);
        return driverLicense != null ? ResponseEntity.ok(driverLicense) : ResponseEntity.notFound().build();
    }
}
