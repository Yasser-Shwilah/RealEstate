package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.entity.Realty;
import com.realestate.Real_Estate.service.MostInteractiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/realties")
public class MostInteractiveController {

    @Autowired
    private MostInteractiveService mostInteractiveService;

    @GetMapping("/top-interactive")
    public ResponseEntity<List<Realty>> getTopInteractiveRealties() {
        List<Realty> topInteractiveRealties = mostInteractiveService.getTopInteractiveRealties();
        return ResponseEntity.ok(topInteractiveRealties);
    }
}
