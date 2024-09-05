package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.CleaningService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningServiceRepository extends JpaRepository<CleaningService, Long> {
}
