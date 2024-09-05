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
    
    private String advertisement_URL; // تأكد من أن هذا الاسم يتطابق مع اسم العمود في قاعدة البيانات
    private String description;
    private double price;
    // private String status;
    @Column(name = "status")
    private String status = "انتظار";
    @OneToOne(mappedBy = "advertisement", cascade = CascadeType.ALL)
    private AdvertisementRequest advertisementRequest;
    @OneToOne
    @JoinColumn(name = "property_location_id")
    private PropertyLocation propertyLocation; // العلاقة مع كيان موقع العقار

  
}
