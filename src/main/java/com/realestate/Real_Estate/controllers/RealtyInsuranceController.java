package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.RealtyInsurance;
import com.realestate.Real_Estate.service.RealtyInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realty-insurances")
public class RealtyInsuranceController {

    @Autowired
    private RealtyInsuranceService realtyInsuranceService;

    // Create a new RealtyInsurance
    @PostMapping
    public ResponseEntity<RealtyInsurance> createRealtyInsurance(@RequestBody RealtyInsurance realtyInsurance) {
        RealtyInsurance createdRealtyInsurance = realtyInsuranceService.createRealtyInsurance(realtyInsurance);
        return new ResponseEntity<>(createdRealtyInsurance, HttpStatus.CREATED);
    }

    // Get all RealtyInsurance entities
    @GetMapping
    public ResponseEntity<List<RealtyInsurance>> getAllRealtyInsurances() {
        List<RealtyInsurance> realtyInsurances = realtyInsuranceService.getAllRealtyInsurances();
        return new ResponseEntity<>(realtyInsurances, HttpStatus.OK);
    }

    // Get a RealtyInsurance by ID
    @GetMapping("/{id}")
    public ResponseEntity<RealtyInsurance> getRealtyInsuranceById(@PathVariable Long id) {
        Optional<RealtyInsurance> realtyInsurance = realtyInsuranceService.getRealtyInsuranceById(id);
        return realtyInsurance.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a RealtyInsurance by ID
    @PutMapping("/{id}")
    public ResponseEntity<RealtyInsurance> updateRealtyInsurance(@PathVariable Long id, @RequestBody RealtyInsurance updatedRealtyInsurance) {
        try {
            RealtyInsurance updated = realtyInsuranceService.updateRealtyInsurance(id, updatedRealtyInsurance);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a RealtyInsurance by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRealtyInsurance(@PathVariable Long id) {
        try {
            realtyInsuranceService.deleteRealtyInsurance(id);
            return new ResponseEntity<>("RealtyInsurance deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("RealtyInsurance not found", HttpStatus.NOT_FOUND);
        }
    }
}

