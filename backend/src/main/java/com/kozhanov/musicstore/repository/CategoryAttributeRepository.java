package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Category;
import com.kozhanov.musicstore.model.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, Integer> {
    List<CategoryAttribute> findByCategory(Category category);
}

