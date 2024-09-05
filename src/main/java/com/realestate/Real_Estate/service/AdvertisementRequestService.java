package com.realestate.Real_Estate.service;



import com.realestate.Real_Estate.entity.AdvertisementRequest;
import com.realestate.Real_Estate.repository.AdvertisementRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementRequestService {

    @Autowired
    private AdvertisementRequestRepository advertisementRequestRepository;

    public AdvertisementRequest createAdvertisementRequest(AdvertisementRequest advertisementRequest) {
        return advertisementRequestRepository.save(advertisementRequest);
    }

    public List<AdvertisementRequest> getAllAdvertisementRequests() {
        return advertisementRequestRepository.findAll();
    }

    public Optional<AdvertisementRequest> getAdvertisementRequestById(Long id) {
        return advertisementRequestRepository.findById(id);
    }

    public AdvertisementRequest updateAdvertisementRequest(Long id, AdvertisementRequest advertisementRequest) {
        Optional<AdvertisementRequest> existingRequest = advertisementRequestRepository.findById(id);
        if (existingRequest.isPresent()) {
            AdvertisementRequest requestToUpdate = existingRequest.get();
            requestToUpdate.setCustomerId(advertisementRequest.getCustomerId());
            requestToUpdate.setManagerId(advertisementRequest.getManagerId());
            requestToUpdate.setDescription(advertisementRequest.getDescription());
            requestToUpdate.setStartDate(advertisementRequest.getStartDate());
            requestToUpdate.setEndDate(advertisementRequest.getEndDate());
            requestToUpdate.setAdvertisement(advertisementRequest.getAdvertisement());
            return advertisementRequestRepository.save(requestToUpdate);
        }
        return null;
    }

    public void deleteAdvertisementRequest(Long id) {
        advertisementRequestRepository.deleteById(id);
    }
}

