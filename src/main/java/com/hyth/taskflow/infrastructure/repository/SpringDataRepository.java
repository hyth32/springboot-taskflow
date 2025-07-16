package com.hyth.taskflow.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyth.taskflow.infrastructure.repository.jpa.UserEntity;

public interface SpringDataRepository extends JpaRepository<UserEntity, Long> {}
