package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    public List<Product> getProductsByCategory(String nameCategory);
    public List<Product> findBySpecification(Specification<Product> spec);
}
