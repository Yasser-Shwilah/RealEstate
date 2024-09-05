package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.RealtyImage;
import com.realestate.Real_Estate.service.RealtyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realty-images")
public class RealtyImageController {

    @Autowired
    private RealtyImageService realtyImageService;

    // Create a new RealtyImage
    @PostMapping
    public ResponseEntity<RealtyImage> createRealtyImage(@RequestBody RealtyImage realtyImage) {
        RealtyImage createdRealtyImage = realtyImageService.createRealtyImage(realtyImage);
        return new ResponseEntity<>(createdRealtyImage, HttpStatus.CREATED);
    }

    // Get all RealtyImage entities
    @GetMapping
    public ResponseEntity<List<RealtyImage>> getAllRealtyImages() {
        List<RealtyImage> realtyImages = realtyImageService.getAllRealtyImages();
        return new ResponseEntity<>(realtyImages, HttpStatus.OK);
    }

    // Get a RealtyImage by ID
    @GetMapping("/{id}")
    public ResponseEntity<RealtyImage> getRealtyImageById(@PathVariable Long id) {
        Optional<RealtyImage> realtyImage = realtyImageService.getRealtyImageById(id);
        return realtyImage.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a RealtyImage by ID
    @PutMapping("/{id}")
    public ResponseEntity<RealtyImage> updateRealtyImage(@PathVariable Long id, @RequestBody RealtyImage updatedRealtyImage) {
        try {
            RealtyImage updated = realtyImageService.updateRealtyImage(id, updatedRealtyImage);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a RealtyImage by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRealtyImage(@PathVariable Long id) {
        try {
            realtyImageService.deleteRealtyImage(id);
            return new ResponseEntity<>("RealtyImage deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("RealtyImage not found", HttpStatus.NOT_FOUND);
        }
    }
}

