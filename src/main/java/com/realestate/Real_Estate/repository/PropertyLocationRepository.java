package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.PropertyLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyLocationRepository extends JpaRepository<PropertyLocation, Long> {
    // يمكنك إضافة استعلامات مخصصة هنا إذا لزم الأمر
}
