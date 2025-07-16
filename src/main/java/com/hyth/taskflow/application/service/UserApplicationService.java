package com.hyth.taskflow.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.hyth.taskflow.domain.model.User;
import com.hyth.taskflow.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserApplicationService {
    
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, String username, String email) {
        User user = getUserById(id);
        return userRepository.save(user.withUsername(username).withEmail(email));
    }

    public User changePassword(Long id, String newPassword) {
        User user = getUserById(id);
        return userRepository.save(user.withPassword(newPassword));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
