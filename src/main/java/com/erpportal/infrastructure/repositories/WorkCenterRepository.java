package com.erpportal.infrastructure.repositories;

import com.erpportal.application.interfaces.IWorkCenterRepository;
import com.erpportal.domain.entities.WorkCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkCenterRepository extends JpaRepository<WorkCenter, Long>, IWorkCenterRepository {
    
    @Override
    Optional<WorkCenter> findByCode(String code);
    
    @Override
    List<WorkCenter> findByIsActiveTrue();
    
    @Override
    boolean existsByCode(String code);
} 