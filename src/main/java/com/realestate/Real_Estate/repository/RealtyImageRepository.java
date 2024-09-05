package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.RealtyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyImageRepository extends JpaRepository<RealtyImage, Long> {
}
