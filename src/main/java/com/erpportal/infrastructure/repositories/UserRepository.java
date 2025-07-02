package com.erpportal.infrastructure.repositories;

import com.erpportal.application.interfaces.IUserRepository;
import com.erpportal.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, IUserRepository {
    
    Optional<User> findByUsername(String username);
    List<User> findByIsActiveTrue();
    boolean existsByUsername(String username);
} 