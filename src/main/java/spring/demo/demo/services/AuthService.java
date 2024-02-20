package spring.demo.demo.services;

import org.springframework.stereotype.Service;

import spring.demo.demo.model.dto.AuthResponseDTO;
import spring.demo.demo.model.dto.SignInDto;
import spring.demo.demo.model.dto.SignUpDto;

@Service
public interface AuthService {
    public int signUp(SignUpDto signUpDto); 
    public AuthResponseDTO signIn(SignInDto signInDto) throws Exception;
}
