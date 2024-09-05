package com.realestate.Real_Estate.entity;


import com.realestate.Real_Estate.entity.Role.RoleType;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = {"phoneNumber"})

})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private int phoneNumber;

    // private String role; // يمكن استخدامها لتحديد صلاحيات المستخدم مثل ADMIN أو USER

    @Enumerated(EnumType.STRING)
    private RoleType role; // role can be ADMIN, MANAGER, or CUSTOMER

        // دالة getRole()
        public RoleType getRole() {
            return role;
        }
    
        // دالة setRole() إذا كنت بحاجة لها
        public void setRole(RoleType role) {
            this.role = role;
        }
}

