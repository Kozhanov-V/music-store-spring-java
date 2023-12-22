package com.kozhanov.musicstore.controller;


import com.kozhanov.musicstore.model.AttributeValue;
import com.kozhanov.musicstore.model.Brand;
import com.kozhanov.musicstore.model.Product;
import com.kozhanov.musicstore.model.Promotion;
import com.kozhanov.musicstore.service.BrandService;
import com.kozhanov.musicstore.service.CategoryService;
import com.kozhanov.musicstore.service.ProductService;
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

    private final ProductService productService;

    private final BrandService brandService;

    public ApiController(PromotionService promotionService, CategoryService categoryService, ProductService productService, BrandService brandService) {
        this.promotionService = promotionService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.brandService = brandService;
    }

    @GetMapping("/promotions/active")
    public ResponseEntity<?> getActivePromotions() {
        return new ResponseEntity<>(promotionService.getAllActivePromotions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion newPromotion = promotionService.addPromotion(promotion);
        return ResponseEntity.ok(newPromotion);
    }

    @GetMapping("/attributes/category/{value}")
    public ResponseEntity<Map<String, List<AttributeValue>>> getAttributesByCategory(@PathVariable("value") String nameCategory) {
        Map<String, List<AttributeValue>> attributes = categoryService.getAttributesAndValuesByCategory(nameCategory);
        return ResponseEntity.ok(attributes);
    }

    @GetMapping("/items/category/{value}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("value") String nameCategory) {
        List<Product> productList = productService.getProductsByCategory(nameCategory);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/brands/category/{value}")
    public ResponseEntity<List<Brand>> getBrandsByCategory(@PathVariable("value") String nameCategory) {
        List<Brand> brandList = brandService.getBrandsByCategoryName(nameCategory);
        return ResponseEntity.ok(brandList);
    }
}
