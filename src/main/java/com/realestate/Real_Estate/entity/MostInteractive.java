package com.realestate.Real_Estate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "MostInteractive")
public class MostInteractive {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

   
    @ManyToOne
    private Realty realty;
}
