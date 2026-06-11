package com.revio.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revio.dto.LoginRequest;
import com.revio.dto.LoginResponse;
import com.revio.security.JwtService;

@RestController
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        if (!request.getEmail().equals("admin@gmail.com")
                || !request.getPassword().equals("admin123")) {

            throw new RuntimeException("Invalid credentials");
        }

        String token =
                jwtService.generateToken(request.getEmail());

        return new LoginResponse(token);
    }
}