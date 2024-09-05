package com.realestate.Real_Estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.realestate.Real_Estate.entity.RealtyViews;

@Repository
public interface RealtyViewsRepository extends JpaRepository<RealtyViews, Long> {
}
