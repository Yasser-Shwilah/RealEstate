package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.PropertyLocation;
import com.realestate.Real_Estate.service.PropertyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/property-locations")
public class PropertyLocationController {

    @Autowired
    private PropertyLocationService propertyLocationService;

    @PostMapping
    public ResponseEntity<PropertyLocation> createPropertyLocation(@RequestBody PropertyLocation propertyLocation) {
        PropertyLocation createdLocation = propertyLocationService.createPropertyLocation(propertyLocation);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPropertyLocation(@PathVariable Long id) {
        Optional<String> optional = Optional.of("Value");
        ResponseEntity<String> response = optional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>("Default Value", HttpStatus.NOT_FOUND));
        return response;
        
            }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePropertyLocation(@PathVariable Long id, @RequestBody PropertyLocation propertyLocation) {
        try {
            PropertyLocation updatedLocation = propertyLocationService.updatePropertyLocation(id, propertyLocation);
            return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update location: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePropertyLocation(@PathVariable Long id) {
        try {
            propertyLocationService.deletePropertyLocation(id);
            return new ResponseEntity<>("Location deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete location: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
