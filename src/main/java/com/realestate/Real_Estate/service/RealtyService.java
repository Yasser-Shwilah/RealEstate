package com.realestate.Real_Estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.Real_Estate.entity.Realty;
import com.realestate.Real_Estate.repository.RealtyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RealtyService {

    @Autowired
    private RealtyRepository realtyRepository;

    public Realty createRealty(Realty realty) {
        return realtyRepository.save(realty);
    }

    public List<Realty> getAllRealties() {
        return realtyRepository.findAll();
    }

    public Optional<Realty> getRealtyById(Long id) {
        return realtyRepository.findById(id);
    }

    public Realty updateRealty(Long id, Realty realtyDetails) {
        Realty realty = realtyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Realty not found"));

        realty.setType(realtyDetails.getType());
        realty.setDescription(realtyDetails.getDescription());
        realty.setCustomer(realtyDetails.getCustomer());
        // قم بتحديث الحقول الأخرى إذا لزم الأمر

        return realtyRepository.save(realty);
    }

    public void deleteRealty(Long id) {
        Realty realty = realtyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Realty not found"));
        realtyRepository.delete(realty);
    }
}

