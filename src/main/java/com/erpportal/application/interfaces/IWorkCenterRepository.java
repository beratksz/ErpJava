package com.erpportal.application.interfaces;

import com.erpportal.domain.entities.WorkCenter;
import java.util.List;
import java.util.Optional;

public interface IWorkCenterRepository {
    Optional<WorkCenter> findByCode(String code);
    Optional<WorkCenter> findById(Long id);
    List<WorkCenter> findAll();
    List<WorkCenter> findByIsActiveTrue();
    WorkCenter save(WorkCenter workCenter);
    void deleteById(Long id);
    boolean existsByCode(String code);
} 