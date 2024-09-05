package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.Loan;
import com.realestate.Real_Estate.entity.LoanRequest;
import com.realestate.Real_Estate.service.LoanRequestService;
import com.realestate.Real_Estate.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    @Autowired
    private LoanRequestService loanRequestService;
    @Autowired
    private LoanService loanService;

    // Get all Loan Requests
    // @GetMapping
    // public ResponseEntity<List<LoanRequest>> getAllLoanRequests() {
    //     List<LoanRequest> loanRequests = loanRequestService.getAllLoanRequests();
    //     return new ResponseEntity<>(loanRequests, HttpStatus.OK);
    // }
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoanRequests() {
        List<Loan> loanRequests = loanService.getAllLoans();
        return new ResponseEntity<>(loanRequests, HttpStatus.OK);
    }

    // Get Loan Request by ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanRequestById(@PathVariable Long id) {
        Optional<Loan> loanRequest = loanService.getLoanById(id);
        return loanRequest.map(ResponseEntity::ok)
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update Loan Request Status
    // @PutMapping("/{id}/status")
    // public ResponseEntity<Loan> updateLoanRequestStatus(@PathVariable Long id, @RequestBody String status) {
    //     Loan updatedLoanRequest = loanService.updateLoanStatus(id, status);
    //     return updatedLoanRequest != null ? new ResponseEntity<>(updatedLoanRequest, HttpStatus.OK)
    //                                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
}

