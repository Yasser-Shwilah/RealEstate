package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.PropertyLocation;
import com.realestate.Real_Estate.repository.PropertyLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyLocationService {

    @Autowired
    private PropertyLocationRepository propertyLocationRepository;

    public PropertyLocation createPropertyLocation(PropertyLocation propertyLocation) {
        return propertyLocationRepository.save(propertyLocation);
    }

    public Optional<PropertyLocation> getPropertyLocationById(Long id) {
        return propertyLocationRepository.findById(id);
    }

    public PropertyLocation updatePropertyLocation(Long id, PropertyLocation propertyLocation) {
        if (propertyLocationRepository.existsById(id)) {
            propertyLocation.setId(id);
            return propertyLocationRepository.save(propertyLocation);
        }
        throw new RuntimeException("Location not found");
    }

    public void deletePropertyLocation(Long id) {
        if (propertyLocationRepository.existsById(id)) {
            propertyLocationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Location not found");
        }
    }
}
