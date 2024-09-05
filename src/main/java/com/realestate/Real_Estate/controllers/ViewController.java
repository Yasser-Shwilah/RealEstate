package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.View;
import com.realestate.Real_Estate.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/views")
public class ViewController {

    @Autowired
    private ViewService viewService;

    // Create a new View
    @PostMapping
    public ResponseEntity<View> createView(@RequestBody View view) {
        View createdView = viewService.createView(view);
        return new ResponseEntity<>(createdView, HttpStatus.CREATED);
    }

    // Get all Views
    @GetMapping
    public ResponseEntity<List<View>> getAllViews() {
        List<View> viewList = viewService.getAllViews();
        return new ResponseEntity<>(viewList, HttpStatus.OK);
    }

    // Get a View by ID
    @GetMapping("/{id}")
    public ResponseEntity<View> getViewById(@PathVariable Long id) {
        Optional<View> view = viewService.getViewById(id);
        return view.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a View by ID
    @PutMapping("/{id}")
    public ResponseEntity<View> updateView(@PathVariable Long id, @RequestBody View updatedView) {
        try {
            View updated = viewService.updateView(id, updatedView);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a View by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteView(@PathVariable Long id) {
        try {
            viewService.deleteView(id);
            return new ResponseEntity<>("View deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("View not found", HttpStatus.NOT_FOUND);
        }
    }
}

