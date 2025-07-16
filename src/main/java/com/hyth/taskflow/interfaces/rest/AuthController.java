package com.hyth.taskflow.interfaces.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyth.taskflow.application.service.AuthApplicationService;
import com.hyth.taskflow.interfaces.rest.dto.auth.AuthDto;
import com.hyth.taskflow.interfaces.rest.dto.auth.AuthResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth", description = "API operations related to user authentication")
@RequiredArgsConstructor
public class AuthController {

    private final AuthApplicationService authApplicationService;
    
    @PostMapping("/login")
    @Operation(summary = "User login", description = "Authenticates a user and returns a JWT token")
    public AuthResponseDto login(@RequestBody @Valid AuthDto authDto) {
        return AuthResponseDto.from(authApplicationService.login(authDto.getUsername(), authDto.getPassword()));
    }
}
