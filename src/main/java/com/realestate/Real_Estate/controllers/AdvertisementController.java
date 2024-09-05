package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.dto.AdvertisementRequestDto;
import com.realestate.Real_Estate.entity.Advertisement;
import com.realestate.Real_Estate.entity.PropertyLocation;
import com.realestate.Real_Estate.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    
    @PostMapping("/create")
    public ResponseEntity<?> createAdvertisement(@RequestBody Advertisement advertisement, @RequestParam Long locationId) {
        try {
            Advertisement createdAdvertisement = advertisementService.createAdvertisementWithLocation(advertisement, locationId);
            return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create advertisement: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Create
    @PostMapping
    public ResponseEntity<?> createAdvertisement(@RequestBody Advertisement advertisement) {
        try {
            Advertisement createdAdvertisement = advertisementService.createAdvertisement(advertisement);
            return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
        } catch (Exception e) {
            // يمكن تسجيل الاستثناءات هنا باستخدام logger
            return new ResponseEntity<>("Failed to create advertisement: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    // Read all
    @GetMapping
    public ResponseEntity<?> getAllAdvertisements() {
        try {
            List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
            return new ResponseEntity<>(advertisements, HttpStatus.OK);
        } catch (Exception e) {
            // يمكن تسجيل الاستثناءات هنا باستخدام logger
            return new ResponseEntity<>("Failed to retrieve advertisements: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable Long id) {
        Optional<Advertisement> advertisement = advertisementService.getAdvertisementById(id);
        return advertisement.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdvertisement(@PathVariable Long id, @RequestBody Advertisement advertisement) {
        try {
            Advertisement updatedAdvertisement = advertisementService.updateAdvertisement(id, advertisement);
            return updatedAdvertisement != null ? new ResponseEntity<>(updatedAdvertisement, HttpStatus.OK)
                    : new ResponseEntity<>("Advertisement not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // يمكن تسجيل الاستثناءات هنا باستخدام logger
            return new ResponseEntity<>("Failed to update advertisement: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

//     // Delete
//     @DeleteMapping("/{id}")
// public ResponseEntity<?> deleteAdvertisement(@PathVariable Long id) {
//     try {
//         advertisementService.deleteAdvertisement(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     } catch (Exception e) {
//         // يمكن تسجيل الاستثناءات هنا باستخدام logger
//         return new ResponseEntity<>("Failed to delete advertisement: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
// Delete
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteAdvertisement(@PathVariable Long id) {
    try {
        if (!advertisementService.existsById(id)) {
            return new ResponseEntity<>("Advertisement not found", HttpStatus.NOT_FOUND);
        }

        advertisementService.deleteAdvertisement(id);
        return new ResponseEntity<>("Advertisement deleted successfully", HttpStatus.OK); // رسالة نجاح الحذف
    } catch (Exception e) {
        // يمكن تسجيل الاستثناءات هنا باستخدام logger
        return new ResponseEntity<>("Failed to delete advertisement: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



}

