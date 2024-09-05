package com.realestate.Real_Estate.dto;

import java.time.LocalDate;
import java.util.Objects;

public class NotificationRequestDto {
    private String message;
    private LocalDate date;
    private Long customerId;

    // Getters and setters

    public NotificationRequestDto() {
    }

    public NotificationRequestDto(String message, LocalDate date, Long customerId) {
        this.message = message;
        this.date = date;
        this.customerId = customerId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public NotificationRequestDto message(String message) {
        setMessage(message);
        return this;
    }

    public NotificationRequestDto date(LocalDate date) {
        setDate(date);
        return this;
    }

    public NotificationRequestDto customerId(Long customerId) {
        setCustomerId(customerId);
        return this;
    }


    
}
