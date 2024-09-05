package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.RealtyImage;
import com.realestate.Real_Estate.repository.RealtyImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealtyImageService {

    @Autowired
    private RealtyImageRepository realtyImageRepository;

    // Create a new RealtyImage
    public RealtyImage createRealtyImage(RealtyImage realtyImage) {
        return realtyImageRepository.save(realtyImage);
    }

    // Get all RealtyImage entities
    public List<RealtyImage> getAllRealtyImages() {
        return realtyImageRepository.findAll();
    }

    // Get a RealtyImage by ID
    public Optional<RealtyImage> getRealtyImageById(Long id) {
        return realtyImageRepository.findById(id);
    }

    // Update a RealtyImage
    public RealtyImage updateRealtyImage(Long id, RealtyImage updatedRealtyImage) {
        return realtyImageRepository.findById(id)
                .map(realtyImage -> {
                    realtyImage.setUrl(updatedRealtyImage.getUrl());
                    realtyImage.setRealty(updatedRealtyImage.getRealty());
                    return realtyImageRepository.save(realtyImage);
                })
                .orElseThrow(() -> new RuntimeException("RealtyImage not found with id " + id));
    }

    // Delete a RealtyImage by ID
    public void deleteRealtyImage(Long id) {
        if (realtyImageRepository.existsById(id)) {
            realtyImageRepository.deleteById(id);
        } else {
            throw new RuntimeException("RealtyImage not found with id " + id);
        }
    }
}
