package com.kozhanov.musicstore.service;

import com.kozhanov.musicstore.model.Promotion;
import com.kozhanov.musicstore.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;



    public List<Promotion> getAllActivePromotions() {
        // Запрос к базе данных для получения всех активных акций
        return promotionRepository.findByIsActiveTrueOrderByEndDateDesc();
    }

    public List<Promotion> getLastTwoActivePromotions() {
        // Запрос к базе данных для получения последних двух активных акций
        return promotionRepository.findByIsActiveTrueOrderByEndDateDesc().stream()
                .limit(2)
                .collect(Collectors.toList());
    }

    public Promotion addPromotion(Promotion promotion) {
        // Сохраняем акцию в базе данных
        return promotionRepository.save(promotion);
    }


}
