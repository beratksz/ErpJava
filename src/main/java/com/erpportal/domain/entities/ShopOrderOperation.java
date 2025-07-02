package com.erpportal.domain.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_order_operations")
public class ShopOrderOperation {
    
    @EmbeddedId
    private ShopOrderOperationId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderNo")
    @JoinColumn(name = "order_no")
    private ShopOrder shopOrder;
    
    @Column(length = 500)
    private String description;
    
    @Column(name = "work_center_code", length = 50)
    private String workCenterCode;
    
    @Column(length = 50)
    private String status;
    
    @Column(name = "start_time")
    private LocalDateTime startTime;
    
    @Column(name = "end_time")
    private LocalDateTime endTime;
    
    @Column(name = "assigned_to", length = 100)
    private String assignedTo;
    
    @Column(name = "reported_by", length = 100)
    private String reportedBy;
    
    @Column(length = 1000)
    private String notes;
    
    @Column(name = "interruption_reason", length = 500)
    private String interruptionReason;
    
    @Column(name = "revised_qty_due", precision = 18, scale = 4)
    private BigDecimal revisedQtyDue;
    
    @Column(name = "qty_complete", precision = 18, scale = 4)
    private BigDecimal qtyComplete;
    
    @Column(name = "qty_scrapped", precision = 18, scale = 4)
    private BigDecimal qtyScrapped;
    
    @Column(name = "mach_setup_time", precision = 18, scale = 4)
    private BigDecimal machSetupTime;
    
    @Column(name = "mach_run_factor", precision = 18, scale = 4)
    private BigDecimal machRunFactor;
    
    @Column(name = "labor_setup_time", precision = 18, scale = 4)
    private BigDecimal laborSetupTime;
    
    @Column(name = "labor_run_factor", precision = 18, scale = 4)
    private BigDecimal laborRunFactor;
    
    @Column(name = "move_time", precision = 18, scale = 4)
    private BigDecimal moveTime;
    
    @Column(name = "queue_time", precision = 18, scale = 4)
    private BigDecimal queueTime;
    
    @Column(name = "efficiency_factor", precision = 18, scale = 4)
    private BigDecimal efficiencyFactor;
    
    @Column(name = "quantity_completed", precision = 18, scale = 4)
    private BigDecimal quantityCompleted;
    
    @Column(name = "quantity_scrapped", precision = 18, scale = 4)
    private BigDecimal quantityScrapped;
    
    @Column(name = "is_awaiting_quality")
    private Boolean isAwaitingQuality = false;
    
    @Column(name = "is_sync_pending")
    private Boolean isSyncPending = false;
    
    @Column(name = "last_sync_error", length = 1000)
    private String lastSyncError;
    
    @Column(name = "last_sync_at")
    private LocalDateTime lastSyncAt;
    
    // Constructors
    public ShopOrderOperation() {}
    
    public ShopOrderOperation(String orderNo, Integer operationNo) {
        this.id = new ShopOrderOperationId(orderNo, operationNo);
    }
    
    // Getters and Setters
    public ShopOrderOperationId getId() {
        return id;
    }
    
    public void setId(ShopOrderOperationId id) {
        this.id = id;
    }
    
    public ShopOrder getShopOrder() {
        return shopOrder;
    }
    
    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getWorkCenterCode() {
        return workCenterCode;
    }
    
    public void setWorkCenterCode(String workCenterCode) {
        this.workCenterCode = workCenterCode;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public String getAssignedTo() {
        return assignedTo;
    }
    
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    public String getReportedBy() {
        return reportedBy;
    }
    
    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getInterruptionReason() {
        return interruptionReason;
    }
    
    public void setInterruptionReason(String interruptionReason) {
        this.interruptionReason = interruptionReason;
    }
    
    public BigDecimal getRevisedQtyDue() {
        return revisedQtyDue;
    }
    
    public void setRevisedQtyDue(BigDecimal revisedQtyDue) {
        this.revisedQtyDue = revisedQtyDue;
    }
    
    public BigDecimal getQtyComplete() {
        return qtyComplete;
    }
    
    public void setQtyComplete(BigDecimal qtyComplete) {
        this.qtyComplete = qtyComplete;
    }
    
    public BigDecimal getQtyScrapped() {
        return qtyScrapped;
    }
    
    public void setQtyScrapped(BigDecimal qtyScrapped) {
        this.qtyScrapped = qtyScrapped;
    }
    
    public Boolean getIsAwaitingQuality() {
        return isAwaitingQuality;
    }
    
    public void setIsAwaitingQuality(Boolean isAwaitingQuality) {
        this.isAwaitingQuality = isAwaitingQuality;
    }
    
    public Boolean getIsSyncPending() {
        return isSyncPending;
    }
    
    public void setIsSyncPending(Boolean isSyncPending) {
        this.isSyncPending = isSyncPending;
    }
    
    public String getLastSyncError() {
        return lastSyncError;
    }
    
    public void setLastSyncError(String lastSyncError) {
        this.lastSyncError = lastSyncError;
    }
    
    public LocalDateTime getLastSyncAt() {
        return lastSyncAt;
    }
    
    public void setLastSyncAt(LocalDateTime lastSyncAt) {
        this.lastSyncAt = lastSyncAt;
    }
    
    // Additional getters/setters for remaining fields...
    public BigDecimal getMachSetupTime() {
        return machSetupTime;
    }
    
    public void setMachSetupTime(BigDecimal machSetupTime) {
        this.machSetupTime = machSetupTime;
    }
    
    public BigDecimal getMachRunFactor() {
        return machRunFactor;
    }
    
    public void setMachRunFactor(BigDecimal machRunFactor) {
        this.machRunFactor = machRunFactor;
    }
    
    public BigDecimal getLaborSetupTime() {
        return laborSetupTime;
    }
    
    public void setLaborSetupTime(BigDecimal laborSetupTime) {
        this.laborSetupTime = laborSetupTime;
    }
    
    public BigDecimal getLaborRunFactor() {
        return laborRunFactor;
    }
    
    public void setLaborRunFactor(BigDecimal laborRunFactor) {
        this.laborRunFactor = laborRunFactor;
    }
    
    public BigDecimal getMoveTime() {
        return moveTime;
    }
    
    public void setMoveTime(BigDecimal moveTime) {
        this.moveTime = moveTime;
    }
    
    public BigDecimal getQueueTime() {
        return queueTime;
    }
    
    public void setQueueTime(BigDecimal queueTime) {
        this.queueTime = queueTime;
    }
    
    public BigDecimal getEfficiencyFactor() {
        return efficiencyFactor;
    }
    
    public void setEfficiencyFactor(BigDecimal efficiencyFactor) {
        this.efficiencyFactor = efficiencyFactor;
    }
    
    public BigDecimal getQuantityCompleted() {
        return quantityCompleted;
    }
    
    public void setQuantityCompleted(BigDecimal quantityCompleted) {
        this.quantityCompleted = quantityCompleted;
    }
    
    public BigDecimal getQuantityScrapped() {
        return quantityScrapped;
    }
    
    public void setQuantityScrapped(BigDecimal quantityScrapped) {
        this.quantityScrapped = quantityScrapped;
    }
}