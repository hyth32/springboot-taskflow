package com.hyth.taskflow.domain.repository;

import java.util.List;
import java.util.Optional;

import com.hyth.taskflow.domain.model.User;

public interface UserRepository {
    Optional<User> findById(Long id);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
}
