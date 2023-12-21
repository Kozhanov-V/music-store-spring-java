package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Category;
import com.kozhanov.musicstore.model.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, Integer> {
    List<CategoryAttribute> findByCategory(Category category);
}

