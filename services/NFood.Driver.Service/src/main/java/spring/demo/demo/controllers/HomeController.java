package spring.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.demo.exception.AppException;

@RestController
public class HomeController {
    @Value("${jwt.secret}")
    private String string;
    @GetMapping("/driver-api/auth/")
    public String helloo() {
        throw new AppException(string);
    }
}
