package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getBrandsByCategoryName(String name);
}
