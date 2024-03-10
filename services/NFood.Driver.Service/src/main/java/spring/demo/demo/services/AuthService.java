package spring.demo.demo.services;

import org.springframework.stereotype.Service;

import spring.demo.demo.model.dto.AuthResponseDto;
import spring.demo.demo.model.dto.SignInDto;
import spring.demo.demo.model.dto.SignUpDto;

@Service
public interface AuthService {
    public int signUp(SignUpDto signUpDto) throws Exception; 
    public AuthResponseDto signIn(SignInDto signInDto) throws Exception;
}
