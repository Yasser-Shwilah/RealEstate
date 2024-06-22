package com.realestate.Real_Estate.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "managers")
public class Manager extends Customer {

    private String department;


    private String adminLevel;
    private LocalDate dateOfAppointment;
    private String specialPermissions;
    private int workingHoursPerWeek;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Advertisement advertisement;

    @OneToMany(mappedBy = "manager")
    private Set<LoanRequest> loanRequests;

    @OneToMany(mappedBy = "manager")
    private Set<Complaint> complaints;
    // مثال: دالة للتحقق من صلاحية خاصة
    public boolean hasPermission(String permission) {
        // تحقق من الصلاحيات
        return specialPermissions != null && specialPermissions.contains(permission);
    }}
