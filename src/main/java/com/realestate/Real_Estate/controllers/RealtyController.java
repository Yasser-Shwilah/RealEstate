package com.realestate.Real_Estate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.realestate.Real_Estate.entity.Realty;
import com.realestate.Real_Estate.entity.RealtyImage;
import com.realestate.Real_Estate.service.RealtyService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/realties")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;

    // إنشاء عقار جديد
    @PostMapping
    public ResponseEntity<Realty> createRealty(@RequestBody Realty realty) {
        Realty newRealty = realtyService.createRealty(realty);
        return new ResponseEntity<>(newRealty, HttpStatus.CREATED);
    }

    // عرض جميع العقارات
    @GetMapping
    public ResponseEntity<List<Realty>> getAllRealties() {
        List<Realty> realties = realtyService.getAllRealties();
        return new ResponseEntity<>(realties, HttpStatus.OK);
    }

    // عرض عقار حسب ID
    @GetMapping("/{id}")
    public ResponseEntity<Realty> getRealtyById(@PathVariable Long id) {
        Realty realty = realtyService.getRealtyById(id)
                .orElseThrow(() -> new RuntimeException("Realty not found"));
        return new ResponseEntity<>(realty, HttpStatus.OK);
    }

    // تحديث عقار
    @PutMapping("/{id}")
    public ResponseEntity<Realty> updateRealty(@PathVariable Long id, @RequestBody Realty realtyDetails) {
        Realty updatedRealty = realtyService.updateRealty(id, realtyDetails);
        return new ResponseEntity<>(updatedRealty, HttpStatus.OK);
    }

    // حذف عقار
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRealty(@PathVariable Long id) {
        realtyService.deleteRealty(id);
        return new ResponseEntity<>("Realty deleted successfully", HttpStatus.OK);
    }
}
