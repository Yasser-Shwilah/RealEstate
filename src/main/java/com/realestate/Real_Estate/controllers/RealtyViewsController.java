package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.RealtyViews;
import com.realestate.Real_Estate.service.RealtyViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realty-views")
public class RealtyViewsController {

    @Autowired
    private RealtyViewsService realtyViewsService;

    // Create a new RealtyViews
    @PostMapping
    public ResponseEntity<RealtyViews> createRealtyViews(@RequestBody RealtyViews realtyViews) {
        RealtyViews createdRealtyViews = realtyViewsService.createRealtyViews(realtyViews);
        return new ResponseEntity<>(createdRealtyViews, HttpStatus.CREATED);
    }

    // Get all RealtyViews entities
    @GetMapping
    public ResponseEntity<List<RealtyViews>> getAllRealtyViews() {
        List<RealtyViews> realtyViewsList = realtyViewsService.getAllRealtyViews();
        return new ResponseEntity<>(realtyViewsList, HttpStatus.OK);
    }

    // Get a RealtyViews by ID
    @GetMapping("/{id}")
    public ResponseEntity<RealtyViews> getRealtyViewsById(@PathVariable Long id) {
        Optional<RealtyViews> realtyViews = realtyViewsService.getRealtyViewsById(id);
        return realtyViews.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a RealtyViews by ID
    @PutMapping("/{id}")
    public ResponseEntity<RealtyViews> updateRealtyViews(@PathVariable Long id, @RequestBody RealtyViews updatedRealtyViews) {
        try {
            RealtyViews updated = realtyViewsService.updateRealtyViews(id, updatedRealtyViews);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a RealtyViews by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRealtyViews(@PathVariable Long id) {
        try {
            realtyViewsService.deleteRealtyViews(id);
            return new ResponseEntity<>("RealtyViews deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("RealtyViews not found", HttpStatus.NOT_FOUND);
        }
    }
}
