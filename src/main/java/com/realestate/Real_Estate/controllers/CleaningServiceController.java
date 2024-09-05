package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.CleaningService;
import com.realestate.Real_Estate.service.CleaningServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaning-services")
public class CleaningServiceController {

    @Autowired
    private CleaningServiceService cleaningServiceService;

    // Create
    @PostMapping
    public ResponseEntity<CleaningService> createCleaningService(@RequestBody CleaningService cleaningService) {
        try {
            CleaningService createdCleaningService = cleaningServiceService.createCleaningService(cleaningService);
            return new ResponseEntity<>(createdCleaningService, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<CleaningService>> getAllCleaningServices() {
        try {
            List<CleaningService> cleaningServices = cleaningServiceService.getAllCleaningServices();
            return new ResponseEntity<>(cleaningServices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<CleaningService> getCleaningServiceById(@PathVariable Long id) {
        Optional<CleaningService> cleaningService = cleaningServiceService.getCleaningServiceById(id);
        return cleaningService.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CleaningService> updateCleaningService(@PathVariable Long id, @RequestBody CleaningService cleaningServiceDetails) {
        try {
            CleaningService updatedCleaningService = cleaningServiceService.updateCleaningService(id, cleaningServiceDetails);
            return updatedCleaningService != null ? new ResponseEntity<>(updatedCleaningService, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCleaningService(@PathVariable Long id) {
        try {
            if (!cleaningServiceService.existsById(id)) {
                return new ResponseEntity<>("Cleaning Service not found", HttpStatus.NOT_FOUND);
            }
            cleaningServiceService.deleteCleaningService(id);
            return new ResponseEntity<>("Cleaning Service deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete Cleaning Service: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
