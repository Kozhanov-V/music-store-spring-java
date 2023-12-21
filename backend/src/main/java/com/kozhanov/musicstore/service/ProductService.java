package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductsByCategory(String nameCategory);
}
