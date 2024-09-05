package com.realestate.Real_Estate.entity;
import java.util.List;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "Realty")
public class Realty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "realty", cascade = CascadeType.ALL)
    private List<RealtyImage> realtyImages;

    @OneToMany(mappedBy = "realty")
    private Set<RealtyViews> realtyViews;

    @OneToMany(mappedBy = "realty")
    private Set<RealtyInsurance> realtyInsurances;

    @OneToOne(mappedBy = "realty")
    private MapService mapService;


    @OneToMany(mappedBy = "realty")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "realty")
    private List<MostInteractive> mostInteractives;

}

