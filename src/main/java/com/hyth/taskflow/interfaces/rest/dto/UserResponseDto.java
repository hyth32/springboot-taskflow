package com.hyth.taskflow.interfaces.rest.dto;

import com.hyth.taskflow.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    
    private Long id;
    private String username;
    private String email;

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }
}
