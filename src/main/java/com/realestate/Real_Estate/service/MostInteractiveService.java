package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.Realty;
import com.realestate.Real_Estate.repository.MostInteractiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostInteractiveService {

    @Autowired
    private MostInteractiveRepository mostInteractiveRepository;

    public List<Realty> getTopInteractiveRealties() {
        return mostInteractiveRepository.findTopInteractiveRealties();
    }
}
