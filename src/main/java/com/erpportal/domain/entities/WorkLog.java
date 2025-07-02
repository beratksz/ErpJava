package com.erpportal.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_logs", indexes = {
    @Index(name = "idx_work_log_operation", columnList = "order_no, operation_no, user_id, start_time")
})
public class WorkLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_no", nullable = false, length = 50)
    private String orderNo;
    
    @Column(name = "operation_no", nullable = false)
    private Integer operationNo;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    
    @Column(name = "end_time")
    private LocalDateTime endTime;
    
    @Column(length = 500)
    private String description;
    
    @Column(length = 1000)
    private String notes;
    
    @Column(length = 50)
    private String status;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Constructors
    public WorkLog() {}
    
    public WorkLog(String orderNo, Integer operationNo, Long userId, LocalDateTime startTime) {
        this.orderNo = orderNo;
        this.operationNo = operationNo;
        this.userId = userId;
        this.startTime = startTime;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
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
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
} 