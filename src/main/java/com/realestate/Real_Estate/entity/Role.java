package com.realestate.Real_Estate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    public static final String ADMIN = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public enum RoleType {
        ADMIN,
        MANAGER,
        CUSTOMER
    }
}

// public enum Role {
//     ADMIN,
//     MANAGER,
//     CUSTOMER
// }