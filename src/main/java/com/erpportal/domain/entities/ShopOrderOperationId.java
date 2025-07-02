package com.erpportal.domain.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class ShopOrderOperationId {
    
    @Column(name = "order_no", length = 50)
    private String orderNo;
    
    @Column(name = "operation_no")
    private Integer operationNo;
    
    // Constructors
    public ShopOrderOperationId() {}
    
    public ShopOrderOperationId(String orderNo, Integer operationNo) {
        this.orderNo = orderNo;
        this.operationNo = operationNo;
    }
    
    // Getters and Setters
    public String getOrderNo() {
        return orderNo;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    public Integer getOperationNo() {
        return operationNo;
    }
    
    public void setOperationNo(Integer operationNo) {
        this.operationNo = operationNo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopOrderOperationId)) return false;
        ShopOrderOperationId that = (ShopOrderOperationId) o;
        return Objects.equals(orderNo, that.orderNo) && Objects.equals(operationNo, that.operationNo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(orderNo, operationNo);
    }
} 