package com.hyth.taskflow.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hyth.taskflow.domain.repository.UserRepository;
import com.hyth.taskflow.infrastructure.repository.jpa.UserEntity;

import com.hyth.taskflow.domain.model.User;

@Repository
public class JpaUserRepository implements UserRepository {
    
    private final SpringDataRepository jpa;

    public JpaUserRepository(SpringDataRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpa.findAll().stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        UserEntity savedEntity = jpa.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    private User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword());
    }

    private UserEntity toEntity(User user) {
        return UserEntity.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .password(user.getPassword())
            .build();
    }
}
