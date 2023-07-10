package com.backend.prueba.repository;

import com.backend.prueba.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: Bruno Avila
 * @FileName: UsersRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Repository
public interface UsersRepository extends JpaRepository<UserEntity , Integer> {
    Optional<UserEntity> findByUsername(String username);
}
