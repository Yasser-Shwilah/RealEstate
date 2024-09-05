package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.TransportService;
import com.realestate.Real_Estate.repository.TransportServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceService {

    @Autowired
    private TransportServiceRepository transportServiceRepository;

    // Create a new TransportService
    public TransportService createTransportService(TransportService transportService) {
        return transportServiceRepository.save(transportService);
    }

    // Get all TransportServices
    public List<TransportService> getAllTransportServices() {
        return transportServiceRepository.findAll();
    }

    // Get a TransportService by ID
    public Optional<TransportService> getTransportServiceById(Long id) {
        return transportServiceRepository.findById(id);
    }

    // Update a TransportService
    public TransportService updateTransportService(Long id, TransportService updatedTransportService) {
        return transportServiceRepository.findById(id)
                .map(transportService -> {
                    transportService.setTransportType(updatedTransportService.getTransportType());
                    return transportServiceRepository.save(transportService);
                })
                .orElseThrow(() -> new RuntimeException("TransportService not found with id " + id));
    }

    // Delete a TransportService by ID
    public void deleteTransportService(Long id) {
        if (transportServiceRepository.existsById(id)) {
            transportServiceRepository.deleteById(id);
        } else {
            throw new RuntimeException("TransportService not found with id " + id);
        }
    }
}
