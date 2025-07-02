package com.erpportal.application.interfaces;

import com.erpportal.application.dto.ShopOrderDto;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IShopOrderApiService {
    CompletableFuture<List<ShopOrderDto>> getOperationsByWorkCenterAsync(String workCenterCode);
    CompletableFuture<Boolean> updateOperationStatusAsync(String orderNo, Integer operationNo, String status, String notes);
} 