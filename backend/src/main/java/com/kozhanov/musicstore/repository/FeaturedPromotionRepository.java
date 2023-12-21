package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.FeaturedPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturedPromotionRepository extends JpaRepository<FeaturedPromotion, Integer> {
}
