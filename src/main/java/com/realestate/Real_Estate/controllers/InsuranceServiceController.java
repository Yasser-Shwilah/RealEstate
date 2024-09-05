package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.InsuranceService;
import com.realestate.Real_Estate.service.InsuranceServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insuranceservices")
public class InsuranceServiceController {

    @Autowired
    private InsuranceServiceService insuranceServiceService;

    // Create
    @PostMapping
    public ResponseEntity<InsuranceService> createInsuranceService(@RequestBody InsuranceService insuranceService) {
        try {
            InsuranceService createdInsuranceService = insuranceServiceService.createInsuranceService(insuranceService);
            return new ResponseEntity<>(createdInsuranceService, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<InsuranceService>> getAllInsuranceServices() {
        try {
            List<InsuranceService> insuranceServices = insuranceServiceService.getAllInsuranceServices();
            return new ResponseEntity<>(insuranceServices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceService> getInsuranceServiceById(@PathVariable Long id) {
        Optional<InsuranceService> insuranceService = insuranceServiceService.getInsuranceServiceById(id);
        return insuranceService.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceService> updateInsuranceService(@PathVariable Long id, @RequestBody InsuranceService insuranceServiceDetails) {
        try {
            InsuranceService updatedInsuranceService = insuranceServiceService.updateInsuranceService(id, insuranceServiceDetails);
            return updatedInsuranceService != null ? new ResponseEntity<>(updatedInsuranceService, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInsuranceService(@PathVariable Long id) {
        try {
            if (!insuranceServiceService.existsById(id)) {
                return new ResponseEntity<>("Insurance service not found", HttpStatus.NOT_FOUND);
            }
            insuranceServiceService.deleteInsuranceService(id);
            return new ResponseEntity<>("Insurance service deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete insurance service: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
