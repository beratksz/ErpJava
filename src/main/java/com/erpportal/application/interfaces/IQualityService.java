package com.erpportal.application.interfaces;

import com.erpportal.domain.entities.ShopOrderOperation;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IQualityService {
    CompletableFuture<List<ShopOrderOperation>> getAwaitingQualityOperationsAsync();
    CompletableFuture<Boolean> approveAsync(String orderNo, Integer operationNo, String approvedBy, String disposition, String notes);
} 