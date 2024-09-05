package com.realestate.Real_Estate.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "InsuranceServices")
public class InsuranceService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String insuranceType;
    private Double insuranceCost;
    private LocalDate startDate;
    private LocalDate endDate;
    private String insuranceProviderInfo;
    private String insuredContactInfo;

    
    @OneToMany(mappedBy = "insuranceService")
    private Set<RealtyInsurance> realtyInsurances ;

}
