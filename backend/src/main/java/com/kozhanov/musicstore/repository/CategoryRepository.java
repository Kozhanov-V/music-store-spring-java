package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Category;
import com.kozhanov.musicstore.model.FeaturedPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Optional<Category> findByName(String name);
}
