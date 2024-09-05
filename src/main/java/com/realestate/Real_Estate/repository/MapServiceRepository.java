package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.MapService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapServiceRepository extends JpaRepository<MapService, Long> {
}
