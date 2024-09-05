package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByCustomerId(Long customerId);
}
