package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Product;
import com.kozhanov.musicstore.repository.ProductRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategory(String nameCategory) {
        return productRepository.findByCategory_Name(nameCategory);
    }

    @Override
    public List<Product> findBySpecification(Specification<Product> spec) {
        return  productRepository.findAll(spec);
    }

}
