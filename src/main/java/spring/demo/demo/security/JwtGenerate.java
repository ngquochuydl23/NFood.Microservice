package spring.demo.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;

public class JwtGenerate {
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWTex)
    }
}
