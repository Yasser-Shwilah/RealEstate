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
@Table(name = "MapServices")
public class MapService {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @OneToOne(mappedBy = "MapService")
    private Realty realty;
}
