package com.erpportal.application.interfaces;

import com.erpportal.application.dto.NcrDto;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface INonConformanceApiService {
    CompletableFuture<List<NcrDto>> getOpenNcrsAsync(String orderNo, Integer operationNo);
    CompletableFuture<Boolean> closeNcrAsync(String ncrNo, String disposition, String notes, String closedBy);
} 