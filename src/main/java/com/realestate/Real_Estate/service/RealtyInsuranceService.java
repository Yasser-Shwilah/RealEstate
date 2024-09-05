package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.RealtyInsurance;
import com.realestate.Real_Estate.repository.RealtyInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealtyInsuranceService {

    @Autowired
    private RealtyInsuranceRepository realtyInsuranceRepository;

    // Create a new RealtyInsurance
    public RealtyInsurance createRealtyInsurance(RealtyInsurance realtyInsurance) {
        return realtyInsuranceRepository.save(realtyInsurance);
    }

    // Get all RealtyInsurance entities
    public List<RealtyInsurance> getAllRealtyInsurances() {
        return realtyInsuranceRepository.findAll();
    }

    // Get a RealtyInsurance by ID
    public Optional<RealtyInsurance> getRealtyInsuranceById(Long id) {
        return realtyInsuranceRepository.findById(id);
    }

    // Update a RealtyInsurance
    public RealtyInsurance updateRealtyInsurance(Long id, RealtyInsurance updatedRealtyInsurance) {
        return realtyInsuranceRepository.findById(id)
                .map(realtyInsurance -> {
                    realtyInsurance.setRealty(updatedRealtyInsurance.getRealty());
                    realtyInsurance.setInsuranceService(updatedRealtyInsurance.getInsuranceService());
                    return realtyInsuranceRepository.save(realtyInsurance);
                })
                .orElseThrow(() -> new RuntimeException("RealtyInsurance not found with id " + id));
    }

    // Delete a RealtyInsurance by ID
    public void deleteRealtyInsurance(Long id) {
        if (realtyInsuranceRepository.existsById(id)) {
            realtyInsuranceRepository.deleteById(id);
        } else {
            throw new RuntimeException("RealtyInsurance not found with id " + id);
        }
    }
}
