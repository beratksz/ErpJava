package com.erpportal.domain.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_centers")
public class WorkCenter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 20)
    private String code;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(length = 500)
    private String description;
    
    @Column(nullable = false)
    private Boolean isActive = true;
    
    @OneToMany(mappedBy = "workCenter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserWorkCenter> userWorkCenters = new ArrayList<>();
    
    // Constructors
    public WorkCenter() {}
    
    public WorkCenter(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public List<UserWorkCenter> getUserWorkCenters() {
        return userWorkCenters;
    }
    
    public void setUserWorkCenters(List<UserWorkCenter> userWorkCenters) {
        this.userWorkCenters = userWorkCenters;
    }
} 