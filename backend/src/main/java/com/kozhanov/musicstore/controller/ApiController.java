package com.kozhanov.musicstore.controller;


import com.kozhanov.musicstore.model.Attribute;
import com.kozhanov.musicstore.model.AttributeValue;
import com.kozhanov.musicstore.model.Promotion;
import com.kozhanov.musicstore.service.CategoryService;
import com.kozhanov.musicstore.service.PromotionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final PromotionService promotionService;

    private final CategoryService categoryService;

    public ApiController(PromotionService promotionService, CategoryService categoryService) {
        this.promotionService = promotionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/promotions/active")
    public ResponseEntity<?> getActivePromotions() {
        String[] add = new String[20];
        return new ResponseEntity<>(promotionService.getAllActivePromotions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion newPromotion = promotionService.addPromotion(promotion);
        return ResponseEntity.ok(newPromotion);
    }

    @GetMapping("/attributes/category/{value}")
    public ResponseEntity<Map<Attribute, List<AttributeValue>>> getAttributesByCategory(@PathVariable("value") int idCategory) {
        Map<Attribute, List<AttributeValue>> attributes = categoryService.getAttributesAndValuesByCategory(idCategory);
        return ResponseEntity.ok(attributes);
    }



}
