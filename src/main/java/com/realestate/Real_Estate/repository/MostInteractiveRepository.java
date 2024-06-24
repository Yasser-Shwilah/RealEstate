package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.MostInteractive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MostInteractiveRepository extends JpaRepository<MostInteractive, Long> {
}
