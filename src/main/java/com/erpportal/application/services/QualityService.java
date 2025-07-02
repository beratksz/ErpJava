package com.erpportal.application.services;

import com.erpportal.application.dto.NcrDto;
import com.erpportal.application.interfaces.INonConformanceApiService;
import com.erpportal.application.interfaces.IQualityService;
import com.erpportal.application.interfaces.IShopOrderOperationRepository;
import com.erpportal.domain.entities.ShopOrderOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional
public class QualityService implements IQualityService {

    private static final Logger logger = LoggerFactory.getLogger(QualityService.class);

    private final IShopOrderOperationRepository operationRepository;
    private final INonConformanceApiService ncrApi;

    @Autowired
    public QualityService(IShopOrderOperationRepository operationRepository,
                         INonConformanceApiService ncrApi) {
        this.operationRepository = operationRepository;
        this.ncrApi = ncrApi;
    }

    @Override
    public CompletableFuture<List<ShopOrderOperation>> getAwaitingQualityOperationsAsync() {
        return CompletableFuture.supplyAsync(() -> 
            operationRepository.findByIsAwaitingQualityTrue());
    }

    @Override
    public CompletableFuture<Boolean> approveAsync(String orderNo, Integer operationNo, 
                                                  String approvedBy, String disposition, String notes) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Get open NCRs for this operation
                List<NcrDto> ncrs = ncrApi.getOpenNcrsAsync(orderNo, operationNo).join();
                
                if (ncrs.isEmpty()) {
                    logger.warn("ApproveAsync: NCR bulunamadı {}/{}", orderNo, operationNo);
                    return false;
                }

                NcrDto ncr = ncrs.get(0);
                
                // Close the NCR
                boolean success = ncrApi.closeNcrAsync(ncr.getNcrNo(), disposition, notes, approvedBy).join();
                if (!success) {
                    return false;
                }

                // Update the operation
                Optional<ShopOrderOperation> operation = operationRepository
                    .findByOrderNoAndOperationNo(orderNo, operationNo);
                    
                if (operation.isEmpty()) {
                    logger.warn("ApproveAsync: Operation DB'de yok {}/{}", orderNo, operationNo);
                    return false;
                }

                ShopOrderOperation op = operation.get();
                op.setIsAwaitingQuality(false);
                op.setLastSyncError(null);
                op.setIsSyncPending(true); // AutoCloseService will handle this

                operationRepository.save(op);
                return true;
                
            } catch (Exception ex) {
                logger.error("ApproveAsync hata {}/{}", orderNo, operationNo, ex);
                return false;
            }
        });
    }
} 