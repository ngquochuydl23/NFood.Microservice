package spring.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.dto.AuthResponseDTO;
import spring.demo.demo.model.dto.SignInDto;
import spring.demo.demo.services.AuthServiceImpl;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInDto signinDto) {
       
       
        try {
            AuthResponseDTO authResponseDTO = this.authServiceImpl.signIn(signinDto);
            return ResponseEntity.ok().body(authResponseDTO);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage().toString());
        }
    }

    @PostMapping("/sign-out")
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
