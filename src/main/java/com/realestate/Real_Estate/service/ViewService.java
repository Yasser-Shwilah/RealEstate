package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.View;
import com.realestate.Real_Estate.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    private ViewRepository viewRepository;

    // Create a new View
    public View createView(View view) {
        return viewRepository.save(view);
    }

    // Get all Views
    public List<View> getAllViews() {
        return viewRepository.findAll();
    }

    // Get a View by ID
    public Optional<View> getViewById(Long id) {
        return viewRepository.findById(id);
    }

    // Update a View
    public View updateView(Long id, View updatedView) {
        return viewRepository.findById(id)
                .map(view -> {
                    view.setDate(updatedView.getDate());
                    view.setCustomer(updatedView.getCustomer());
                    view.setRealtyViews(updatedView.getRealtyViews());
                    return viewRepository.save(view);
                })
                .orElseThrow(() -> new RuntimeException("View not found with id " + id));
    }

    // Delete a View by ID
    public void deleteView(Long id) {
        if (viewRepository.existsById(id)) {
            viewRepository.deleteById(id);
        } else {
            throw new RuntimeException("View not found with id " + id);
        }
    }
}

