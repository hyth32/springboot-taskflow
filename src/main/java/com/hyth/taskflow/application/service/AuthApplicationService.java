package com.hyth.taskflow.application.service;

import org.springframework.stereotype.Service;

import com.hyth.taskflow.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthApplicationService {
    
    private final JwtService jwtService;
    private final UserApplicationService userApplicationService;

    public String login(String username, String password) {
        User user = userApplicationService.getUserByUsername(username);

        if (!user.checkPassword(password)) {
            throw new RuntimeException("Invalid username or password");
        };

        return jwtService.generateToken(username);
    }
}
