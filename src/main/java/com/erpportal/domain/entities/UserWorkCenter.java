package com.erpportal.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_work_centers")
public class UserWorkCenter {
    
    @EmbeddedId
    private UserWorkCenterId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("workCenterId")
    @JoinColumn(name = "work_center_id")
    private WorkCenter workCenter;
    
    // Constructors
    public UserWorkCenter() {}
    
    public UserWorkCenter(User user, WorkCenter workCenter) {
        this.user = user;
        this.workCenter = workCenter;
        this.id = new UserWorkCenterId(user.getId(), workCenter.getId());
    }
    
    // Getters and Setters
    public UserWorkCenterId getId() {
        return id;
    }
    
    public void setId(UserWorkCenterId id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public WorkCenter getWorkCenter() {
        return workCenter;
    }
    
    public void setWorkCenter(WorkCenter workCenter) {
        this.workCenter = workCenter;
    }
}

@Embeddable
class UserWorkCenterId {
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "work_center_id")
    private Long workCenterId;
    
    // Constructors
    public UserWorkCenterId() {}
    
    public UserWorkCenterId(Long userId, Long workCenterId) {
        this.userId = userId;
        this.workCenterId = workCenterId;
    }
    
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getWorkCenterId() {
        return workCenterId;
    }
    
    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserWorkCenterId)) return false;
        UserWorkCenterId that = (UserWorkCenterId) o;
        return userId.equals(that.userId) && workCenterId.equals(that.workCenterId);
    }
    
    @Override
    public int hashCode() {
        return userId.hashCode() + workCenterId.hashCode();
    }
} 