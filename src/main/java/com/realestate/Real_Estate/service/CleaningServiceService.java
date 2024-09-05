package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.CleaningService;
import com.realestate.Real_Estate.repository.CleaningServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningServiceService {

    @Autowired
    private CleaningServiceRepository cleaningServiceRepository;

    public CleaningService createCleaningService(CleaningService cleaningService) {
        return cleaningServiceRepository.save(cleaningService);
    }

    public List<CleaningService> getAllCleaningServices() {
        return cleaningServiceRepository.findAll();
    }

    public Optional<CleaningService> getCleaningServiceById(Long id) {
        return cleaningServiceRepository.findById(id);
    }

    public CleaningService updateCleaningService(Long id, CleaningService cleaningServiceDetails) {
        return cleaningServiceRepository.findById(id)
                .map(cleaningService -> {
                    cleaningService.setCleaningType(cleaningServiceDetails.getCleaningType());
                    return cleaningServiceRepository.save(cleaningService);
                })
                .orElse(null);
    }

    public void deleteCleaningService(Long id) {
        cleaningServiceRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return cleaningServiceRepository.existsById(id);
    }
}

