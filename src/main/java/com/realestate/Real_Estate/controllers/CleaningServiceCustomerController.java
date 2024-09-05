package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.CleaningServiceCustomer;
import com.realestate.Real_Estate.service.CleaningServiceCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaning-service-customers")
public class CleaningServiceCustomerController {

    @Autowired
    private CleaningServiceCustomerService cleaningServiceCustomerService;

    // Create
    @PostMapping
    public ResponseEntity<CleaningServiceCustomer> createCleaningServiceCustomer(@RequestBody CleaningServiceCustomer cleaningServiceCustomer) {
        try {
            CleaningServiceCustomer createdCleaningServiceCustomer = cleaningServiceCustomerService.createCleaningServiceCustomer(cleaningServiceCustomer);
            return new ResponseEntity<>(createdCleaningServiceCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<CleaningServiceCustomer>> getAllCleaningServiceCustomers() {
        try {
            List<CleaningServiceCustomer> cleaningServiceCustomers = cleaningServiceCustomerService.getAllCleaningServiceCustomers();
            return new ResponseEntity<>(cleaningServiceCustomers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<CleaningServiceCustomer> getCleaningServiceCustomerById(@PathVariable Long id) {
        Optional<CleaningServiceCustomer> cleaningServiceCustomer = cleaningServiceCustomerService.getCleaningServiceCustomerById(id);
        return cleaningServiceCustomer.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CleaningServiceCustomer> updateCleaningServiceCustomer(@PathVariable Long id, @RequestBody CleaningServiceCustomer cleaningServiceCustomerDetails) {
        try {
            CleaningServiceCustomer updatedCleaningServiceCustomer = cleaningServiceCustomerService.updateCleaningServiceCustomer(id, cleaningServiceCustomerDetails);
            return updatedCleaningServiceCustomer != null ? new ResponseEntity<>(updatedCleaningServiceCustomer, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCleaningServiceCustomer(@PathVariable Long id) {
        try {
            if (!cleaningServiceCustomerService.existsById(id)) {
                return new ResponseEntity<>("Cleaning Service Customer not found", HttpStatus.NOT_FOUND);
            }
            cleaningServiceCustomerService.deleteCleaningServiceCustomer(id);
            return new ResponseEntity<>("Cleaning Service Customer deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete Cleaning Service Customer: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
