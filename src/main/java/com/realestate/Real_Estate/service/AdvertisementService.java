package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.Advertisement;
import com.realestate.Real_Estate.entity.PropertyLocation;
import com.realestate.Real_Estate.repository.AdvertisementRepository;
import com.realestate.Real_Estate.repository.PropertyLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private PropertyLocationRepository propertyLocationRepository;

    public Advertisement createAdvertisementWithLocation(Advertisement advertisement, Long locationId) {
        PropertyLocation location = propertyLocationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        advertisement.setPropertyLocation(location);
        return advertisementRepository.save(advertisement);
    }
    // Create
    public Advertisement createAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    // Read
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Optional<Advertisement> getAdvertisementById(Long id) {
        return advertisementRepository.findById(id);
    }

    // Update
    public Advertisement updateAdvertisement(Long id, Advertisement advertisement) {
        if (advertisementRepository.existsById(id)) {
            advertisement.setId(id);
            return advertisementRepository.save(advertisement);
        }
        return null;
    }

    // Delete
    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return advertisementRepository.existsById(id);
    }
}
