package com.realestate.Real_Estate.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Data
@Entity
@Table(name = "MapServices")
public class MapService {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mapUrl;
    private Double latitude;
    private Double longitude;

   
    @OneToOne
    @JoinColumn(name = "mapservice_id")
    private Realty realty;
    
}
