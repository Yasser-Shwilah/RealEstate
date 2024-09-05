package com.realestate.Real_Estate.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

// @Setter
// @Getter
// @Data
// @Entity
// @Table(name = "Notifications")
// public class Notification {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String message;
//     private LocalDate date;

//     @ManyToOne
//     @JoinColumn(name = "customer_id") // هنا تأكد من أن اسم العمود مطابق لاسم العمود في قاعدة البيانات
//     private Customer customer;
    
// }

@Setter
@Getter
@Data
@Entity
@Table(name = "Notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    

    public Notification() {
    }

    public Notification(Long id, String message, LocalDate date, Customer customer) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Notification id(Long id) {
        setId(id);
        return this;
    }

    public Notification message(String message) {
        setMessage(message);
        return this;
    }

    public Notification date(LocalDate date) {
        setDate(date);
        return this;
    }

    public Notification customer(Customer customer) {
        setCustomer(customer);
        return this;
    }


}
