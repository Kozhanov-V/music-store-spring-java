package com.kozhanov.musicstore.controller;


import com.kozhanov.musicstore.model.Promotion;
import com.kozhanov.musicstore.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotions/active")
    public ResponseEntity<?> getActivePromotions() {
        return new ResponseEntity<>(promotionService.getAllActivePromotions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion newPromotion = promotionService.addPromotion(promotion);
        return ResponseEntity.ok(newPromotion);
    }



}
