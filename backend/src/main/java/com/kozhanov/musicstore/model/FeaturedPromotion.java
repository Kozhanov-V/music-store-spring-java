package com.kozhanov.musicstore.model;

import javax.persistence.*;

@Entity
@Table(name = "featured_promotions")
public class FeaturedPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "featured_Promotion_id")
    private Integer featuredPromotionId;

    @Column(name = "displayOrder")
    private Integer displayOrder;

    @ManyToOne
    @JoinColumn(name = "promotionId")
    private Promotion promotion;

    public Integer getFeaturedPromotionId() {
        return featuredPromotionId;
    }

    public void setFeaturedPromotionId(Integer featuredPromotionId) {
        this.featuredPromotionId = featuredPromotionId;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    // Геттеры и сеттеры
}