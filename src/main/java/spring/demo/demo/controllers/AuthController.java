package spring.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.dto.SigninDto;
import spring.demo.demo.services.AuthServiceImpl;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthServiceImpl authServiceImpl;

    @GetMapping("/sign-up")
    public String register() {
        return "Register page";
    }

    @PostMapping
    public ResponseEntity<String> signIn(@Valid @RequestBody SigninDto signinDto) {
        return null;
    }

    @PostMapping
    public String signout() {
        return "Logout";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpDto> signUp(@Valid @RequestBody SignUpDto signUpDto) {

        int signUp = this.authServiceImpl.signUp(signUpDto);

        return signUp == HttpStatus.OK.value() ? ResponseEntity.status(signUp).body(signUpDto)
                : ResponseEntity.status(signUp).body(null);
    }

}
