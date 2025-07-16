package com.hyth.taskflow.interfaces.rest.dto.auth;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {
    
    private String token;

    public static AuthResponseDto from(String token) {
        return new AuthResponseDto(token);
    }
}
