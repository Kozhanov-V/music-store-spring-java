package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Category;
import com.kozhanov.musicstore.model.FeaturedPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
