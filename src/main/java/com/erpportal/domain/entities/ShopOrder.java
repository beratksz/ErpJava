package com.erpportal.domain.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_orders")
public class ShopOrder {
    
    @Id
    @Column(name = "order_no", length = 50)
    private String orderNo;
    
    @Column(length = 500)
    private String description;
    
    @Column(name = "part_no", length = 50)
    private String partNo;
    
    @Column(name = "part_description", length = 500)
    private String partDescription;
    
    @Column(length = 50)
    private String status;
    
    @Column(precision = 18, scale = 4)
    private BigDecimal quantity;
    
    @Column(name = "need_date")
    private LocalDateTime needDate;
    
    @Column(length = 1000)
    private String notes;
    
    @Column(name = "last_sync_at")
    private LocalDateTime lastSyncAt;
    
    @OneToMany(mappedBy = "shopOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShopOrderOperation> operations = new ArrayList<>();
    
    // Constructors
    public ShopOrder() {}
    
    public ShopOrder(String orderNo) {
        this.orderNo = orderNo;
    }
    
    // Getters and Setters
    public String getOrderNo() {
        return orderNo;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getPartNo() {
        return partNo;
    }
    
    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }
    
    public String getPartDescription() {
        return partDescription;
    }
    
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public BigDecimal getQuantity() {
        return quantity;
    }
    
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    
    public LocalDateTime getNeedDate() {
        return needDate;
    }
    
    public void setNeedDate(LocalDateTime needDate) {
        this.needDate = needDate;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public LocalDateTime getLastSyncAt() {
        return lastSyncAt;
    }
    
    public void setLastSyncAt(LocalDateTime lastSyncAt) {
        this.lastSyncAt = lastSyncAt;
    }
    
    public List<ShopOrderOperation> getOperations() {
        return operations;
    }
    
    public void setOperations(List<ShopOrderOperation> operations) {
        this.operations = operations;
    }
} 