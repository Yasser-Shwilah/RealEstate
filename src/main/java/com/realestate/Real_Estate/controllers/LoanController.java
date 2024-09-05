package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.Loan;
import com.realestate.Real_Estate.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Create
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        try {
            Loan createdLoan = loanService.createLoan(loan);
            return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        try {
            List<Loan> loans = loanService.getAllLoans();
            return new ResponseEntity<>(loans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Optional<Loan> loan = loanService.getLoanById(id);
        return loan.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
        try {
            Loan updatedLoan = loanService.updateLoan(id, loanDetails);
            return updatedLoan != null ? new ResponseEntity<>(updatedLoan, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id) {
        try {
            if (!loanService.existsById(id)) {
                return new ResponseEntity<>("Loan not found", HttpStatus.NOT_FOUND);
            }
            loanService.deleteLoan(id);
            return new ResponseEntity<>("Loan deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete loan: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        // تحديث حالة طلب القرض
        @PutMapping("/{id}/status")
        public ResponseEntity<String> updateLoanStatus(@PathVariable Long id, @RequestBody String status) {
            Loan updatedLoan = loanService.updateLoanStatus(id, status);
            if (updatedLoan != null) {
                return new ResponseEntity<>("Loan status updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Loan not found", HttpStatus.NOT_FOUND);
            }
        }
}
