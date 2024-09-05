package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.Complaint;
import com.realestate.Real_Estate.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    public Complaint updateComplaint(Long id, Complaint complaintDetails) {
        return complaintRepository.findById(id)
                .map(complaint -> {
                    complaint.setComplaintType(complaintDetails.getComplaintType());
                    complaint.setComplaints(complaintDetails.getComplaints());
                    complaint.setModificationDate(complaintDetails.getModificationDate());
                    complaint.setManager(complaintDetails.getManager());
                    complaint.setCustomer(complaintDetails.getCustomer());
                    return complaintRepository.save(complaint);
                })
                .orElse(null);
    }

    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return complaintRepository.existsById(id);
    }
}
