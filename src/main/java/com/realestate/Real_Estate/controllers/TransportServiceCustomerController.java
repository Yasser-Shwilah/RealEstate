package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.TransportServiceCustomer;
import com.realestate.Real_Estate.service.TransportServiceCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transport-service-customers")
public class TransportServiceCustomerController {

    @Autowired
    private TransportServiceCustomerService transportServiceCustomerService;

    // Create a new TransportServiceCustomer
    @PostMapping
    public ResponseEntity<TransportServiceCustomer> createTransportServiceCustomer(@RequestBody TransportServiceCustomer transportServiceCustomer) {
        TransportServiceCustomer createdTransportServiceCustomer = transportServiceCustomerService.createTransportServiceCustomer(transportServiceCustomer);
        return new ResponseEntity<>(createdTransportServiceCustomer, HttpStatus.CREATED);
    }

    // Get all TransportServiceCustomers
    @GetMapping
    public ResponseEntity<List<TransportServiceCustomer>> getAllTransportServiceCustomers() {
        List<TransportServiceCustomer> transportServiceCustomerList = transportServiceCustomerService.getAllTransportServiceCustomers();
        return new ResponseEntity<>(transportServiceCustomerList, HttpStatus.OK);
    }

    // Get a TransportServiceCustomer by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransportServiceCustomer> getTransportServiceCustomerById(@PathVariable Long id) {
        Optional<TransportServiceCustomer> transportServiceCustomer = transportServiceCustomerService.getTransportServiceCustomerById(id);
        return transportServiceCustomer.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a TransportServiceCustomer by ID
    @PutMapping("/{id}")
    public ResponseEntity<TransportServiceCustomer> updateTransportServiceCustomer(@PathVariable Long id, @RequestBody TransportServiceCustomer updatedTransportServiceCustomer) {
        try {
            TransportServiceCustomer updated = transportServiceCustomerService.updateTransportServiceCustomer(id, updatedTransportServiceCustomer);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a TransportServiceCustomer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransportServiceCustomer(@PathVariable Long id) {
        try {
            transportServiceCustomerService.deleteTransportServiceCustomer(id);
            return new ResponseEntity<>("TransportServiceCustomer deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("TransportServiceCustomer not found", HttpStatus.NOT_FOUND);
        }
    }
}

