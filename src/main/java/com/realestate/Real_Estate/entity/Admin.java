package com.realestate.Real_Estate.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import jakarta.persistence.*; 

//import javax.management.relation.Role;
@Setter
@Getter
@Data
@Entity
@Table(name = "Admins", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"phoneNumber"})
})public class Admin  {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private int phoneNumber;

@OneToMany(mappedBy = "admin")
    private Set<Manager> managers;
    
   /*  @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;*/

   
}
