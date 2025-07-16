package com.hyth.taskflow.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyth.taskflow.application.service.UserApplicationService;
import com.hyth.taskflow.domain.model.User;
import com.hyth.taskflow.interfaces.rest.dto.user.UserResponseDto;
import com.hyth.taskflow.interfaces.rest.dto.user.UserStoreDto;
import com.hyth.taskflow.interfaces.rest.dto.user.UserUpdateDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "API operations related to user management")
@RequiredArgsConstructor
public class UserController {
    
    private final UserApplicationService userApplicationService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieves a list of all users in the system")
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userApplicationService.getAllUsers();
        return users.stream()
            .map(UserResponseDto::from)
            .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Retrieves a user by their unique ID")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return UserResponseDto.from(userApplicationService.getUserById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Creates a new user with the provided details")
    public UserResponseDto createUser(@RequestBody @Valid UserStoreDto userDto) {
        User user = new User(null, userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        return UserResponseDto.from(userApplicationService.createUser(user));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user details", description = "Updates the details of an existing user")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDto userDto) {
        return UserResponseDto.from(userApplicationService.updateUser(id, userDto.getUsername(), userDto.getEmail()));
    }
    
    @PutMapping("/{id}/change-password")
    @Operation(summary = "Change user password", description = "Changes the password of an existing user")
    public UserResponseDto changePassword(@PathVariable Long id, @RequestBody String newPassword) {
        return UserResponseDto.from(userApplicationService.changePassword(id, newPassword));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", description = "Deletes a user by their unique ID")
    public void deleteUser(@PathVariable Long id) {
        userApplicationService.deleteUser(id);
    }
}
