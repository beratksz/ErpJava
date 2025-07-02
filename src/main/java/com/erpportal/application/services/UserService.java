package com.erpportal.application.services;

import com.erpportal.application.interfaces.IUserRepository;
import com.erpportal.application.interfaces.IUserService;
import com.erpportal.application.interfaces.IWorkCenterRepository;
import com.erpportal.domain.entities.User;
import com.erpportal.domain.entities.UserWorkCenter;
import com.erpportal.domain.entities.WorkCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IWorkCenterRepository workCenterRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository, 
                      IWorkCenterRepository workCenterRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.workCenterRepository = workCenterRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getIsActive() && 
            passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(String username, String password, String fullName, boolean isAdmin) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists: " + username);
        }
        
        User user = new User(username, passwordEncoder.encode(password), fullName);
        user.setIsAdmin(isAdmin);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<WorkCenter> getUserWorkCenters(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get().getUserWorkCenters().stream()
                    .map(UserWorkCenter::getWorkCenter)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @Override
    public void assignUserToWorkCenter(Long userId, Long workCenterId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<WorkCenter> workCenter = workCenterRepository.findById(workCenterId);
        
        if (user.isPresent() && workCenter.isPresent()) {
            UserWorkCenter userWorkCenter = new UserWorkCenter(user.get(), workCenter.get());
            user.get().getUserWorkCenters().add(userWorkCenter);
            userRepository.save(user.get());
        }
    }

    @Override
    public void removeUserFromWorkCenter(Long userId, Long workCenterId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            user.get().getUserWorkCenters().removeIf(uwc -> 
                uwc.getWorkCenter().getId().equals(workCenterId));
            userRepository.save(user.get());
        }
    }
} 