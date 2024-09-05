package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.CleaningServiceCustomer;
import com.realestate.Real_Estate.repository.CleaningServiceCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningServiceCustomerService {

    @Autowired
    private CleaningServiceCustomerRepository cleaningServiceCustomerRepository;

    public CleaningServiceCustomer createCleaningServiceCustomer(CleaningServiceCustomer cleaningServiceCustomer) {
        return cleaningServiceCustomerRepository.save(cleaningServiceCustomer);
    }

    public List<CleaningServiceCustomer> getAllCleaningServiceCustomers() {
        return cleaningServiceCustomerRepository.findAll();
    }

    public Optional<CleaningServiceCustomer> getCleaningServiceCustomerById(Long id) {
        return cleaningServiceCustomerRepository.findById(id);
    }

    public CleaningServiceCustomer updateCleaningServiceCustomer(Long id, CleaningServiceCustomer cleaningServiceCustomerDetails) {
        return cleaningServiceCustomerRepository.findById(id)
                .map(cleaningServiceCustomer -> {
                    cleaningServiceCustomer.setCleaningService(cleaningServiceCustomerDetails.getCleaningService());
                    cleaningServiceCustomer.setCustomer(cleaningServiceCustomerDetails.getCustomer());
                    return cleaningServiceCustomerRepository.save(cleaningServiceCustomer);
                })
                .orElse(null);
    }

    public void deleteCleaningServiceCustomer(Long id) {
        cleaningServiceCustomerRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return cleaningServiceCustomerRepository.existsById(id);
    }
}

