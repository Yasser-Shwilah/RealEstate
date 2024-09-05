package com.realestate.Real_Estate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "Loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double rate;
    private Double fee;
    private Double amount;
    private String startDate;
    private String endDate;
    private String status;
    private String borrowerName;
    private String collateral;
    private String paymentSchedule;
    private String remarks;
    @OneToOne
    @JoinColumn(name = "loan_request_id")
    
    private LoanRequest loanRequest;

}
