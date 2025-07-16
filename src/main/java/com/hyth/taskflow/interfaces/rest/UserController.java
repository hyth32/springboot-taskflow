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
import com.hyth.taskflow.interfaces.rest.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserApplicationService userApplicationService;

    @GetMapping
    public List<User> getAllUsers() {
        return userApplicationService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userApplicationService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User user = new User(null, userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        return userApplicationService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userApplicationService.updateUser(id, userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
    }
    
    @PutMapping("/{id}/change-password")
    public User changePassword(@PathVariable Long id, @RequestBody String newPassword) {
        return userApplicationService.changePassword(id, newPassword);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userApplicationService.deleteUser(id);
    }
}
