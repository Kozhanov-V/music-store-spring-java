package com.kozhanov.musicstore.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kozhanov.musicstore.dto.FilterParamsDTO;
import com.kozhanov.musicstore.model.AttributeValue;
import com.kozhanov.musicstore.model.Brand;
import com.kozhanov.musicstore.model.Product;
import com.kozhanov.musicstore.model.Promotion;
import com.kozhanov.musicstore.service.BrandService;
import com.kozhanov.musicstore.service.CategoryService;
import com.kozhanov.musicstore.service.ProductService;
import com.kozhanov.musicstore.service.PromotionService;
import com.kozhanov.musicstore.specifications.ProductSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/items/filter")
    public ResponseEntity<List<Product>> getItemsByFilterParams( @ModelAttribute FilterParamsDTO filterParams) {


        System.out.println(filterParams);

        // Проверка на null и пустоту списка
        if (filterParams.getListBrands() == null || filterParams.getListBrands().isEmpty()) {
            new IllegalStateException("List is empty");
        }

        HashMap<String, List<String>> attributesMap = parseAttributes(filterParams.getAttributes());


        List<Brand> brands = filterParams.getListBrands().stream()
                .map(brandService::getBrandByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        Specification<Product> spec = Specification.where(null);

        spec = spec.and(ProductSpecifications.byCategory(filterParams.getCategory()));
        spec = spec.and(ProductSpecifications.byBrand(brands));
        spec = spec.and(ProductSpecifications.priceInRange(filterParams.getMinPrice(), filterParams.getMaxPrice()));
        if(filterParams.isWithDiscount())
        spec = spec.and(ProductSpecifications.withDiscount(filterParams.isWithDiscount()));
        spec = spec.and(ProductSpecifications.byAttributes(attributesMap));

        List<Product> products =  productService.findBySpecification(spec);
        return ResponseEntity.ok(products);
    }

    private HashMap<String, List<String>> parseAttributes(String attributesStr) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, List<String>>> typeRef = new TypeReference<HashMap<String, List<String>>>() {};
        HashMap<String, List<String>> attributesMap;

        try {
            attributesMap = mapper.readValue(attributesStr, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }

        return attributesMap;
    }

}
