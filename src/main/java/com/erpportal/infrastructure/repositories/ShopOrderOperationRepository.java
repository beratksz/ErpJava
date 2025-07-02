package com.erpportal.infrastructure.repositories;

import com.erpportal.application.interfaces.IShopOrderOperationRepository;
import com.erpportal.domain.entities.ShopOrderOperation;
import com.erpportal.domain.entities.ShopOrderOperationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopOrderOperationRepository extends JpaRepository<ShopOrderOperation, ShopOrderOperationId>, IShopOrderOperationRepository {
    
    @Override
    @Query("SELECT soo FROM ShopOrderOperation soo WHERE soo.id.orderNo = :orderNo AND soo.id.operationNo = :operationNo")
    Optional<ShopOrderOperation> findByOrderNoAndOperationNo(@Param("orderNo") String orderNo, @Param("operationNo") Integer operationNo);
    
    @Override
    List<ShopOrderOperation> findByWorkCenterCode(String workCenterCode);
    
    @Override
    List<ShopOrderOperation> findByIsAwaitingQualityTrue();
    
    @Override
    List<ShopOrderOperation> findByIsSyncPendingTrue();
} 