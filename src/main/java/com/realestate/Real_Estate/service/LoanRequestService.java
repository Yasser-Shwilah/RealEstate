package com.realestate.Real_Estate.service;
import com.realestate.Real_Estate.entity.LoanRequest;
import com.realestate.Real_Estate.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    // Get all Loan Requests
    public List<LoanRequest> getAllLoanRequests() {
        return loanRequestRepository.findAll();
    }

    // Get Loan Request by ID
    public Optional<LoanRequest> getLoanRequestById(Long id) {
        return loanRequestRepository.findById(id);
    }

    // Update Loan Request Status
    public LoanRequest updateLoanRequestStatus(Long id, String status) {
        return loanRequestRepository.findById(id)
                .map(loanRequest -> {
                    // Assuming there's a 'status' field in the LoanRequest entity
                    loanRequest.getLoan().setStatus(status);
                    return loanRequestRepository.save(loanRequest);
                })
                .orElse(null);
    }
}
