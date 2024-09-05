package com.realestate.Real_Estate.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
@Entity
@Table(name = "TransportService")
public class TransportService {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String transportType;

     @OneToMany(mappedBy = "transportService")
     private List<TransportServiceCustomer> transportServiceCustomers;
     

}
