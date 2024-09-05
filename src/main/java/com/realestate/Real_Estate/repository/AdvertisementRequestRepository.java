package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.AdvertisementRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRequestRepository extends JpaRepository<AdvertisementRequest, Long> {
}
