package com.erpportal.application.interfaces;

import com.erpportal.domain.entities.User;
import com.erpportal.domain.entities.WorkCenter;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> authenticate(String username, String password);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    List<User> getAllUsers();
    User createUser(String username, String password, String fullName, boolean isAdmin);
    User updateUser(User user);
    void deleteUser(Long id);
    List<WorkCenter> getUserWorkCenters(Long userId);
    void assignUserToWorkCenter(Long userId, Long workCenterId);
    void removeUserFromWorkCenter(Long userId, Long workCenterId);
} 