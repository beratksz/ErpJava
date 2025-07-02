package com.erpportal.infrastructure.repositories;

import com.erpportal.application.interfaces.IShopOrderRepository;
import com.erpportal.domain.entities.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, String>, IShopOrderRepository {
    
    @Override
    Optional<ShopOrder> findByOrderNo(String orderNo);
    
    @Override
    void deleteByOrderNo(String orderNo);
    
    @Override
    boolean existsByOrderNo(String orderNo);
} 