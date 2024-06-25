package com.example.demo.securty;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date

import static com.example.demo.securty.SecurityConstants.JWTexpiration;

@Component
public class JWTGenerator {

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWTexpiration);


//        String token = jwt.builder
    }

}
