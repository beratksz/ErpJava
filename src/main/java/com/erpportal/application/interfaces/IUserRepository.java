package com.erpportal.application.interfaces;

import com.erpportal.domain.entities.User;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    List<User> findAll();
    List<User> findByIsActiveTrue();
    User save(User user);
    void deleteById(Long id);
    boolean existsByUsername(String username);
} 