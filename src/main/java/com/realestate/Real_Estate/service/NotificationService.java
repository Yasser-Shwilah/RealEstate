package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.Customer;
import com.realestate.Real_Estate.entity.Notification;
import com.realestate.Real_Estate.repository.CustomerRepository;
import com.realestate.Real_Estate.repository.NotificationRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
   @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Notification createNotification(String message, LocalDate date, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setDate(date);
        notification.setCustomer(customer);

        return notificationRepository.save(notification);
    }
    // public Notification createNotification(Notification notification) {
    //     return notificationRepository.save(notification);
    // }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsByCustomerId(Long customerId) {
        return notificationRepository.findByCustomerId(customerId);
    }

    public Notification updateNotification(Long id, Notification notificationDetails) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setMessage(notificationDetails.getMessage());
            notification.setDate(notificationDetails.getDate());
            return notificationRepository.save(notification);
        }).orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
