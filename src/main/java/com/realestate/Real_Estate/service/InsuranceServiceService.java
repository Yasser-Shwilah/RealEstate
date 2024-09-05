package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.InsuranceService;
import com.realestate.Real_Estate.repository.InsuranceServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceServiceService {

    @Autowired
    private InsuranceServiceRepository insuranceServiceRepository;

    public InsuranceService createInsuranceService(InsuranceService insuranceService) {
        return insuranceServiceRepository.save(insuranceService);
    }

    public List<InsuranceService> getAllInsuranceServices() {
        return insuranceServiceRepository.findAll();
    }

    public Optional<InsuranceService> getInsuranceServiceById(Long id) {
        return insuranceServiceRepository.findById(id);
    }

    public InsuranceService updateInsuranceService(Long id, InsuranceService insuranceServiceDetails) {
        return insuranceServiceRepository.findById(id)
                .map(insuranceService -> {
                    insuranceService.setInsuranceType(insuranceServiceDetails.getInsuranceType());
                    insuranceService.setInsuranceCost(insuranceServiceDetails.getInsuranceCost());
                    insuranceService.setStartDate(insuranceServiceDetails.getStartDate());
                    insuranceService.setEndDate(insuranceServiceDetails.getEndDate());
                    insuranceService.setInsuranceProviderInfo(insuranceServiceDetails.getInsuranceProviderInfo());
                    insuranceService.setInsuredContactInfo(insuranceServiceDetails.getInsuredContactInfo());
                    return insuranceServiceRepository.save(insuranceService);
                })
                .orElse(null);
    }

    public void deleteInsuranceService(Long id) {
        insuranceServiceRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return insuranceServiceRepository.existsById(id);
    }
}
