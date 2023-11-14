package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.FeaturedPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturedPromotionRepository extends JpaRepository<FeaturedPromotion, Integer> {
}
