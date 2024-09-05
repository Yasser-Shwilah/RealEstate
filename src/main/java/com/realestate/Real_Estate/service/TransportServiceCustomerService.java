package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.TransportServiceCustomer;
import com.realestate.Real_Estate.repository.TransportServiceCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceCustomerService {

    @Autowired
    private TransportServiceCustomerRepository transportServiceCustomerRepository;

    // Create a new TransportServiceCustomer
    public TransportServiceCustomer createTransportServiceCustomer(TransportServiceCustomer transportServiceCustomer) {
        return transportServiceCustomerRepository.save(transportServiceCustomer);
    }

    // Get all TransportServiceCustomers
    public List<TransportServiceCustomer> getAllTransportServiceCustomers() {
        return transportServiceCustomerRepository.findAll();
    }

    // Get a TransportServiceCustomer by ID
    public Optional<TransportServiceCustomer> getTransportServiceCustomerById(Long id) {
        return transportServiceCustomerRepository.findById(id);
    }

    // Update a TransportServiceCustomer
    public TransportServiceCustomer updateTransportServiceCustomer(Long id, TransportServiceCustomer updatedTransportServiceCustomer) {
        return transportServiceCustomerRepository.findById(id)
                .map(transportServiceCustomer -> {
                    transportServiceCustomer.setTransportService(updatedTransportServiceCustomer.getTransportService());
                    transportServiceCustomer.setCustomer(updatedTransportServiceCustomer.getCustomer());
                    return transportServiceCustomerRepository.save(transportServiceCustomer);
                })
                .orElseThrow(() -> new RuntimeException("TransportServiceCustomer not found with id " + id));
    }

    // Delete a TransportServiceCustomer by ID
    public void deleteTransportServiceCustomer(Long id) {
        if (transportServiceCustomerRepository.existsById(id)) {
            transportServiceCustomerRepository.deleteById(id);
        } else {
            throw new RuntimeException("TransportServiceCustomer not found with id " + id);
        }
    }
}

