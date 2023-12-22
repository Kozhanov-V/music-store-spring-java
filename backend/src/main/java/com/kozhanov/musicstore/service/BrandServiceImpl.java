package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Brand;
import com.kozhanov.musicstore.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getBrandsByCategoryName(String name) {
        return brandRepository.findBrandsByCategoryName(name);
    }
}
