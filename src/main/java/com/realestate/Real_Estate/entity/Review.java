package com.realestate.Real_Estate.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
@Entity
@Table(name = "Review")
public class Review {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Double rate;
    private String comments;
    private String reviewdate;


    @ManyToOne
    @JoinColumn(name = "realty_id")
    private Realty realty;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
}
