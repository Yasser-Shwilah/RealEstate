package com.realestate.Real_Estate.dto;

import java.time.LocalDate;

public class AdvertisementRequestDto {
    private Long id;
    private Long customerId;
    private Long managerId;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long advertisementId; // لتخزين معرف الإعلان
    private Long propertyLocationId; // لتخزين معرف الموقع

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public Long getPropertyLocationId() {
        return propertyLocationId;
    }

    public void setPropertyLocationId(Long propertyLocationId) {
        this.propertyLocationId = propertyLocationId;
    }
}
