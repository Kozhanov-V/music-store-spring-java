package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    public List<Brand> getBrandsByCategoryName(String name);
    public Optional<Brand> getBrandByName(String name);
}
