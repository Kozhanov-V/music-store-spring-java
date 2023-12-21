package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Attribute;
import com.kozhanov.musicstore.model.AttributeValue;
import com.kozhanov.musicstore.model.Category;
import com.kozhanov.musicstore.model.CategoryAttribute;
import com.kozhanov.musicstore.repository.AttributeRepository;
import com.kozhanov.musicstore.repository.AttributeValueRepository;
import com.kozhanov.musicstore.repository.CategoryAttributeRepository;
import com.kozhanov.musicstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final AttributeRepository attributeRepository;

    private final AttributeValueRepository attributeValueRepository;

    private final CategoryAttributeRepository categoryAttributeRepository;

    public CategoryService(CategoryRepository categoryRepository, AttributeRepository attributeRepository, AttributeValueRepository attributeValueRepository, CategoryAttributeRepository categoryAttributeRepository){
        this.categoryRepository = categoryRepository;
        this.attributeRepository = attributeRepository;
        this.attributeValueRepository = attributeValueRepository;
        this.categoryAttributeRepository = categoryAttributeRepository;
    }

    public Map<String, List<AttributeValue>> getAttributesAndValuesByCategory(String nameCategory) {
        Category category = categoryRepository.findByName(nameCategory)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        List<CategoryAttribute> categoryAttributes = categoryAttributeRepository.findByCategory(category);

        return categoryAttributes.stream()
                .collect(Collectors.toMap(
                        ca -> ca.getAttribute().getName(),
                        ca -> attributeValueRepository.findByAttributeId(ca.getAttribute().getId()),
                        (existing, replacement) -> existing
                ));
    }



}

