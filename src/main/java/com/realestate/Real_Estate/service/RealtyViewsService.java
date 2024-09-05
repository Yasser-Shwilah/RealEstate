package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.RealtyViews;
import com.realestate.Real_Estate.repository.RealtyViewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealtyViewsService {

    @Autowired
    private RealtyViewsRepository realtyViewsRepository;

    // Create a new RealtyViews
    public RealtyViews createRealtyViews(RealtyViews realtyViews) {
        return realtyViewsRepository.save(realtyViews);
    }

    // Get all RealtyViews entities
    public List<RealtyViews> getAllRealtyViews() {
        return realtyViewsRepository.findAll();
    }

    // Get a RealtyViews by ID
    public Optional<RealtyViews> getRealtyViewsById(Long id) {
        return realtyViewsRepository.findById(id);
    }

    // Update a RealtyViews
    public RealtyViews updateRealtyViews(Long id, RealtyViews updatedRealtyViews) {
        return realtyViewsRepository.findById(id)
                .map(realtyViews -> {
                    realtyViews.setDate(updatedRealtyViews.getDate());
                    realtyViews.setRealty(updatedRealtyViews.getRealty());
                    realtyViews.setView(updatedRealtyViews.getView());
                    return realtyViewsRepository.save(realtyViews);
                })
                .orElseThrow(() -> new RuntimeException("RealtyViews not found with id " + id));
    }

    // Delete a RealtyViews by ID
    public void deleteRealtyViews(Long id) {
        if (realtyViewsRepository.existsById(id)) {
            realtyViewsRepository.deleteById(id);
        } else {
            throw new RuntimeException("RealtyViews not found with id " + id);
        }
    }
}

