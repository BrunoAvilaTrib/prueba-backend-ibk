package com.backend.prueba.repository;

import com.backend.prueba.entity.UserEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: Bruno Avila
 * @FileName: UserRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

public interface UserRepository extends JpaRepository<UserEntity , Integer> {
    Optional<UserEntity> findByUsername(String username);
}
