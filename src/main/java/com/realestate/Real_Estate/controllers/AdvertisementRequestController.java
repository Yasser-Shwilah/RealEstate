package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.AdvertisementRequest;
import com.realestate.Real_Estate.service.AdvertisementRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advertisement-requests")
public class AdvertisementRequestController {

    @Autowired
    private AdvertisementRequestService advertisementRequestService;

    // Create
    @PostMapping
    public ResponseEntity<AdvertisementRequest> createAdvertisementRequest(@RequestBody AdvertisementRequest advertisementRequest) {
        try {
            AdvertisementRequest createdRequest = advertisementRequestService.createAdvertisementRequest(advertisementRequest);
            return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<AdvertisementRequest>> getAllAdvertisementRequests() {
        try {
            List<AdvertisementRequest> requests = advertisementRequestService.getAllAdvertisementRequests();
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementRequest> getAdvertisementRequestById(@PathVariable Long id) {
        Optional<AdvertisementRequest> request = advertisementRequestService.getAdvertisementRequestById(id);
        return request.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementRequest> updateAdvertisementRequest(@PathVariable Long id, @RequestBody AdvertisementRequest advertisementRequest) {
        try {
            AdvertisementRequest updatedRequest = advertisementRequestService.updateAdvertisementRequest(id, advertisementRequest);
            if (updatedRequest != null) {
                return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisementRequest(@PathVariable Long id) {
        try {
            advertisementRequestService.deleteAdvertisementRequest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

