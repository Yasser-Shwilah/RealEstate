package com.realestate.Real_Estate.entity;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "Customers", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"}),
    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"phoneNumber"})
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;
    private int phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<AdvertisementRequest> advertisementRequests;

    @OneToMany(mappedBy = "customer")
    private Set<LoanRequest> loanRequests;

    @OneToMany(mappedBy = "customer")
    private Set<Complaint> complaints;

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "customer")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "customer")
    private Set<TransportServiceCustomer> transportServiceCustomers;

    @OneToMany(mappedBy = "customer")
    private Set<CleaningServiceCustomer> cleaningServiceCustomers;

    @OneToMany(mappedBy = "customer")
    private Set<Realty> realty;
}
