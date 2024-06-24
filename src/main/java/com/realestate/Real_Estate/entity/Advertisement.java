package com.realestate.Real_Estate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "Advertisements")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String Advertisement_URL;
    private String description;
    private double price;
    
    @OneToOne(mappedBy = "advertisement", cascade = CascadeType.ALL)
    private AdvertisementRequest advertisementRequest;

  
}
