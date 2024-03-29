package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    public List<Promotion> findByIsActiveTrueOrderByEndDateDesc();
}
