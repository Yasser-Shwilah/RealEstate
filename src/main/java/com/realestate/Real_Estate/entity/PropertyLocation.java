package com.realestate.Real_Estate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "PropertyLocations")
public class PropertyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude; // خط العرض
    private Double longitude; // خط الطول

    private String address; // العنوان الذي يمكن أن يكون مرتبطاً بالعقار

    @OneToOne(mappedBy = "propertyLocation")
    private Advertisement advertisement; // العلاقة مع كيان الإعلان
}
