package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.TransportService;
import com.realestate.Real_Estate.service.TransportServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transport-services")
public class TransportServiceController {

    @Autowired
    private TransportServiceService transportServiceService;

    // Create a new TransportService
    @PostMapping
    public ResponseEntity<TransportService> createTransportService(@RequestBody TransportService transportService) {
        TransportService createdTransportService = transportServiceService.createTransportService(transportService);
        return new ResponseEntity<>(createdTransportService, HttpStatus.CREATED);
    }

    // Get all TransportServices
    @GetMapping
    public ResponseEntity<List<TransportService>> getAllTransportServices() {
        List<TransportService> transportServiceList = transportServiceService.getAllTransportServices();
        return new ResponseEntity<>(transportServiceList, HttpStatus.OK);
    }

    // Get a TransportService by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransportService> getTransportServiceById(@PathVariable Long id) {
        Optional<TransportService> transportService = transportServiceService.getTransportServiceById(id);
        return transportService.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a TransportService by ID
    @PutMapping("/{id}")
    public ResponseEntity<TransportService> updateTransportService(@PathVariable Long id, @RequestBody TransportService updatedTransportService) {
        try {
            TransportService updated = transportServiceService.updateTransportService(id, updatedTransportService);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a TransportService by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransportService(@PathVariable Long id) {
        try {
            transportServiceService.deleteTransportService(id);
            return new ResponseEntity<>("TransportService deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("TransportService not found", HttpStatus.NOT_FOUND);
        }
    }
}

