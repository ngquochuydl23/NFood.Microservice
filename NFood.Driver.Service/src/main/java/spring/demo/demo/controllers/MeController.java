package spring.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import spring.demo.demo.exception.AppException;
import spring.demo.demo.exception.NotFoundException;
import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.dto.DriverLicenseDto;
import spring.demo.demo.model.dto.VehicleDto;
import spring.demo.demo.security.JWTUtils;
import spring.demo.demo.services.DriverServiceImpl;
import spring.demo.demo.services.MeServiceImpl;

@RestController
@RequestMapping("/driver-api/driver/me")
public class MeController {
    @Autowired
    private MeServiceImpl meServiceImpl;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private DriverServiceImpl driverServiceImpl;

    private String extractToken(HttpServletRequest request) {
        try {
            String authHeader = request.getHeader("Authorization");
            return jwtUtils.extractTokenFromHeader(authHeader);
        } catch (Exception e) {
            throw new AppException("Token extraction failed");
        }
    }

    @GetMapping("")
    public ResponseEntity<DriverDto> getProfile(@AuthenticationPrincipal UserDetails userDetails,
            HttpServletRequest request) {
        try {
            String token = this.extractToken(request);
            DriverDto driverDto = this.meServiceImpl.getProfile(token);

            return driverDto != null ? ResponseEntity.ok().body(driverDto) : ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            throw new AppException("User not found");
        }
    }

    @GetMapping("/vehicle")
    public ResponseEntity<VehicleDto> getMyVehicle(@AuthenticationPrincipal UserDetails userDetails,
            HttpServletRequest request) {
        try {
            String token = this.extractToken(request);
            DriverDto driverDto = this.meServiceImpl.getProfile(token);
            VehicleDto result = this.driverServiceImpl.getVehicleByDriverId(driverDto.getId());

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new NotFoundException("Vehicle not found");
        }
    }

    @GetMapping("/driver-license")
    public ResponseEntity<DriverLicenseDto> getMyDriverLicense(@AuthenticationPrincipal UserDetails userDetails,
            HttpServletRequest request) {
        try {
            String token = this.extractToken(request);
            DriverDto driverDto = this.meServiceImpl.getProfile(token);
            DriverLicenseDto result = this.driverServiceImpl.getDriverLicenseByDriverId(driverDto.getId());

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new NotFoundException("Drvier License not found");
        }
    }

}
