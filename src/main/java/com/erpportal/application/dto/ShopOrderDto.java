package com.erpportal.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShopOrderDto {
    
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("OperationNo")
    private Integer operationNo;
    
    @JsonProperty("OperationDescription")
    private String operationDescription;
    
    @JsonProperty("WorkCenterNo")
    private String workCenterNo;
    
    @JsonProperty("Contract")
    private String contract;
    
    @JsonProperty("ReleaseNo")
    private String releaseNo;
    
    @JsonProperty("SequenceNo")
    private String sequenceNo;
    
    @JsonProperty("OpSequenceNo")
    private Integer opSequenceNo;
    
    @JsonProperty("EfficiencyFactor")
    private BigDecimal efficiencyFactor;
    
    @JsonProperty("MachRunFactor")
    private BigDecimal machRunFactor;
    
    @JsonProperty("MachSetupTime")
    private BigDecimal machSetupTime;
    
    @JsonProperty("MoveTime")
    private BigDecimal moveTime;
    
    @JsonProperty("QueueTime")
    private BigDecimal queueTime;
    
    @JsonProperty("LaborRunFactor")
    private BigDecimal laborRunFactor;
    
    @JsonProperty("LaborSetupTime")
    private BigDecimal laborSetupTime;
    
    @JsonProperty("RevisedQtyDue")
    private BigDecimal revisedQtyDue;
    
    @JsonProperty("OperStatusCode")
    private String status;
    
    @JsonProperty("PartNo")
    private String partNo;
    
    @JsonProperty("PartDescription")
    private String partDescription;
    
    @JsonProperty("OpStartDate")
    private LocalDateTime opStartDate;
    
    @JsonProperty("OpFinishDate")
    private LocalDateTime opFinishDate;
    
    @JsonProperty("QtyComplete")
    private BigDecimal qtyComplete;
    
    @JsonProperty("QtyScrapped")
    private BigDecimal qtyScrapped;
    
    @JsonProperty("NoteText")
    private String notes;
    
    @JsonProperty("@odata.etag")
    private String eTag;
    
    // Constructors
    public ShopOrderDto() {}
    
    // Getters and Setters
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    
    public Integer getOperationNo() { return operationNo; }
    public void setOperationNo(Integer operationNo) { this.operationNo = operationNo; }
    
    public String getOperationDescription() { return operationDescription; }
    public void setOperationDescription(String operationDescription) { this.operationDescription = operationDescription; }
    
    public String getWorkCenterNo() { return workCenterNo; }
    public void setWorkCenterNo(String workCenterNo) { this.workCenterNo = workCenterNo; }
    
    public String getContract() { return contract; }
    public void setContract(String contract) { this.contract = contract; }
    
    public String getReleaseNo() { return releaseNo; }
    public void setReleaseNo(String releaseNo) { this.releaseNo = releaseNo; }
    
    public String getSequenceNo() { return sequenceNo; }
    public void setSequenceNo(String sequenceNo) { this.sequenceNo = sequenceNo; }
    
    public Integer getOpSequenceNo() { return opSequenceNo; }
    public void setOpSequenceNo(Integer opSequenceNo) { this.opSequenceNo = opSequenceNo; }
    
    public BigDecimal getEfficiencyFactor() { return efficiencyFactor; }
    public void setEfficiencyFactor(BigDecimal efficiencyFactor) { this.efficiencyFactor = efficiencyFactor; }
    
    public BigDecimal getMachRunFactor() { return machRunFactor; }
    public void setMachRunFactor(BigDecimal machRunFactor) { this.machRunFactor = machRunFactor; }
    
    public BigDecimal getMachSetupTime() { return machSetupTime; }
    public void setMachSetupTime(BigDecimal machSetupTime) { this.machSetupTime = machSetupTime; }
    
    public BigDecimal getMoveTime() { return moveTime; }
    public void setMoveTime(BigDecimal moveTime) { this.moveTime = moveTime; }
    
    public BigDecimal getQueueTime() { return queueTime; }
    public void setQueueTime(BigDecimal queueTime) { this.queueTime = queueTime; }
    
    public BigDecimal getLaborRunFactor() { return laborRunFactor; }
    public void setLaborRunFactor(BigDecimal laborRunFactor) { this.laborRunFactor = laborRunFactor; }
    
    public BigDecimal getLaborSetupTime() { return laborSetupTime; }
    public void setLaborSetupTime(BigDecimal laborSetupTime) { this.laborSetupTime = laborSetupTime; }
    
    public BigDecimal getRevisedQtyDue() { return revisedQtyDue; }
    public void setRevisedQtyDue(BigDecimal revisedQtyDue) { this.revisedQtyDue = revisedQtyDue; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getPartNo() { return partNo; }
    public void setPartNo(String partNo) { this.partNo = partNo; }
    
    public String getPartDescription() { return partDescription; }
    public void setPartDescription(String partDescription) { this.partDescription = partDescription; }
    
    public LocalDateTime getOpStartDate() { return opStartDate; }
    public void setOpStartDate(LocalDateTime opStartDate) { this.opStartDate = opStartDate; }
    
    public LocalDateTime getOpFinishDate() { return opFinishDate; }
    public void setOpFinishDate(LocalDateTime opFinishDate) { this.opFinishDate = opFinishDate; }
    
    public BigDecimal getQtyComplete() { return qtyComplete; }
    public void setQtyComplete(BigDecimal qtyComplete) { this.qtyComplete = qtyComplete; }
    
    public BigDecimal getQtyScrapped() { return qtyScrapped; }
    public void setQtyScrapped(BigDecimal qtyScrapped) { this.qtyScrapped = qtyScrapped; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getETag() { return eTag; }
    public void setETag(String eTag) { this.eTag = eTag; }
}

class ShopOrderDetailsDto extends ShopOrderDto {
    private String customerName;
    private String customerOrderNo;
    private List<ShopOrderOperationDto> operations = new ArrayList<>();
    
    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getCustomerOrderNo() { return customerOrderNo; }
    public void setCustomerOrderNo(String customerOrderNo) { this.customerOrderNo = customerOrderNo; }
    
    public List<ShopOrderOperationDto> getOperations() { return operations; }
    public void setOperations(List<ShopOrderOperationDto> operations) { this.operations = operations; }
}

class ShopOrderOperationDto {
    private String orderNo;
    private Integer operationNo;
    private String workCenterCode;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String assignedTo;
    private String operationDescription;
    private String description;
    private BigDecimal quantityCompleted;
    private BigDecimal quantityScrapped;
    private String notes;
    private String operStatusCode;
    private BigDecimal qtyComplete;
    private BigDecimal qtyScrapped;
    private String noteText;
    private String reportedBy;
    
    // Getters and Setters...
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    
    public Integer getOperationNo() { return operationNo; }
    public void setOperationNo(Integer operationNo) { this.operationNo = operationNo; }
    
    public String getWorkCenterCode() { return workCenterCode; }
    public void setWorkCenterCode(String workCenterCode) { this.workCenterCode = workCenterCode; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    
    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    
    public String getOperationDescription() { return operationDescription; }
    public void setOperationDescription(String operationDescription) { this.operationDescription = operationDescription; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public BigDecimal getQuantityCompleted() { return quantityCompleted; }
    public void setQuantityCompleted(BigDecimal quantityCompleted) { this.quantityCompleted = quantityCompleted; }
    
    public BigDecimal getQuantityScrapped() { return quantityScrapped; }
    public void setQuantityScrapped(BigDecimal quantityScrapped) { this.quantityScrapped = quantityScrapped; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getOperStatusCode() { return operStatusCode; }
    public void setOperStatusCode(String operStatusCode) { this.operStatusCode = operStatusCode; }
    
    public BigDecimal getQtyComplete() { return qtyComplete; }
    public void setQtyComplete(BigDecimal qtyComplete) { this.qtyComplete = qtyComplete; }
    
    public BigDecimal getQtyScrapped() { return qtyScrapped; }
    public void setQtyScrapped(BigDecimal qtyScrapped) { this.qtyScrapped = qtyScrapped; }
    
    public String getNoteText() { return noteText; }
    public void setNoteText(String noteText) { this.noteText = noteText; }
    
    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }
} 