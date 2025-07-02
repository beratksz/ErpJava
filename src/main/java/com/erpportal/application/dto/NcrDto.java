package com.erpportal.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NcrDto {
    
    @JsonProperty("NcrNo")
    private String ncrNo;
    
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("OperationNo")
    private Integer operationNo;
    
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("Status")
    private String status;
    
    @JsonProperty("CreatedBy")
    private String createdBy;
    
    @JsonProperty("Notes")
    private String notes;
    
    // Constructors
    public NcrDto() {}
    
    // Getters and Setters
    public String getNcrNo() { return ncrNo; }
    public void setNcrNo(String ncrNo) { this.ncrNo = ncrNo; }
    
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    
    public Integer getOperationNo() { return operationNo; }
    public void setOperationNo(Integer operationNo) { this.operationNo = operationNo; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
} 