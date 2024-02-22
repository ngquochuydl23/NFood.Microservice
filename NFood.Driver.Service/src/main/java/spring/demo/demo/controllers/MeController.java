package spring.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.services.MeServiceImpl;

@RestController
@RequestMapping("/driver-api/driver/me")
public class MeController {
    @Autowired
    private MeServiceImpl meServiceImpl;

    @GetMapping("")
    public ResponseEntity<DriverDto> getProfile() {
        DriverDto driverDto = this.meServiceImpl.getProfile();
        return driverDto != null ? ResponseEntity.ok().body(driverDto) : ResponseEntity.badRequest().body(null);
    }

    
}
