package com.erpportal.application.interfaces;

import com.erpportal.domain.entities.ShopOrderOperation;
import com.erpportal.domain.entities.ShopOrderOperationId;
import java.util.List;
import java.util.Optional;

public interface IShopOrderOperationRepository {
    Optional<ShopOrderOperation> findById(ShopOrderOperationId id);
    Optional<ShopOrderOperation> findByOrderNoAndOperationNo(String orderNo, Integer operationNo);
    List<ShopOrderOperation> findByWorkCenterCode(String workCenterCode);
    List<ShopOrderOperation> findByIsAwaitingQualityTrue();
    List<ShopOrderOperation> findByIsSyncPendingTrue();
    ShopOrderOperation save(ShopOrderOperation operation);
    void deleteById(ShopOrderOperationId id);
} 