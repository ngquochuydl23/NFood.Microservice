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
import spring.demo.demo.model.dto.SignUpResponseDto;
import spring.demo.demo.model.mapper.SignUpResponseDtoMapper;
import spring.demo.demo.exception.AppException;
import spring.demo.demo.model.dto.AuthResponseDto;
import spring.demo.demo.model.dto.SignInDto;
import spring.demo.demo.services.AuthServiceImpl;

@RestController
@RequestMapping("/driver-api/auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInDto signinDto) {
        try {
            AuthResponseDto authResponseDTO = this.authServiceImpl.signIn(signinDto);
            int status = authResponseDTO.getStatusCode();
            return status == 200 ? ResponseEntity.ok().body(authResponseDTO)
                    : ResponseEntity.status(status).body(authResponseDTO);

        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    @PostMapping("/sign-out")
    public String signout() {
        return "Logout";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponseDto> signUp(@Valid @RequestBody SignUpDto signUpDto) {
        try {
            int signUp = this.authServiceImpl.signUp(signUpDto);
            SignUpResponseDto signUpResponseDto = SignUpResponseDtoMapper.toSignUpResponseDto(signUpDto);

            return signUp == HttpStatus.OK.value() ? ResponseEntity.status(signUp).body(signUpResponseDto)
                    : ResponseEntity.status(signUp).body(null);
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

}
