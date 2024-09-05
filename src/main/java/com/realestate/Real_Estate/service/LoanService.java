package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.Loan;
import com.realestate.Real_Estate.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan updateLoan(Long id, Loan loanDetails) {
        return loanRepository.findById(id)
                .map(loan -> {
                    loan.setRate(loanDetails.getRate());
                    loan.setFee(loanDetails.getFee());
                    loan.setAmount(loanDetails.getAmount());
                    loan.setStartDate(loanDetails.getStartDate());
                    loan.setEndDate(loanDetails.getEndDate());
                    loan.setStatus(loanDetails.getStatus());
                    loan.setBorrowerName(loanDetails.getBorrowerName());
                    loan.setCollateral(loanDetails.getCollateral());
                    loan.setPaymentSchedule(loanDetails.getPaymentSchedule());
                    loan.setRemarks(loanDetails.getRemarks());
                    loan.setLoanRequest(loanDetails.getLoanRequest());
                    return loanRepository.save(loan);
                })
                .orElse(null);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return loanRepository.existsById(id);
    }

    // تحديث حالة القرض
    public Loan updateLoanStatus(Long id, String status) {
        Optional<Loan> loanOptional = loanRepository.findById(id);
        if (loanOptional.isPresent()) {
            Loan loan = loanOptional.get();
            loan.setStatus(status); // تحديث حالة القرض
            return loanRepository.save(loan);
        } else {
            return null; // أو يمكنك اختيار رفع استثناء إذا لم يتم العثور على القرض
        }
    }
}
