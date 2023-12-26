package com.kozhanov.musicstore.dto;

import java.util.HashMap;
import java.util.List;

public class FilterParamsDTO {
    private String category;
    private List<String> listBrands;
    private int minPrice;
    private int maxPrice;
    private boolean withDiscount;
    private String attributes;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getListBrands() {
        return listBrands;
    }

    public void setListBrands(List<String> listBrands) {
        this.listBrands = listBrands;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean isWithDiscount() {
        return withDiscount;
    }

    public void setWithDiscount(boolean withDiscount) {
        this.withDiscount = withDiscount;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "FilterParamsDTO{" +
                "category='" + category + '\'' +
                ", listBrands=" + listBrands +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", withDiscount=" + withDiscount +
                ", attributes=" + attributes +
                '}';
    }
}
