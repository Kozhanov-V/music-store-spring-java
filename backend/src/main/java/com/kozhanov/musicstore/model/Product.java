package com.kozhanov.musicstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

   private String name;

   private String description;

   private double price;

    @Column(name = "stock_quantity")
   private int stockQuantity;

    @Column(name = "discount")
    @Check(constraints = "discount >= 0 AND discount <= 50")
   private int discounts;

@Column(name = "url_on_img")
    private String urlOnImg;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonManagedReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brandId")
    @JsonManagedReference
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<Review> reviews;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<ProductAttributeValue> productAttributeValues;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }



    public void addReviews(Review review) {
        if(reviews == null){
            reviews = new HashSet<>();
        }
        this.reviews.add(review);
    }

    public int getDiscounts() {
        return discounts;
    }

    public void setDiscounts(int discounts) {
        this.discounts = discounts;
    }

    public String getUrlOnImg() {
        return urlOnImg;
    }

    public void setUrlOnImg(String urlOnImg) {
        this.urlOnImg = urlOnImg;
    }

    public Set<ProductAttributeValue> getProductAttributeValues() {
        return productAttributeValues;
    }

    public void setProductAttributeValues(Set<ProductAttributeValue> productAttributeValues) {
        this.productAttributeValues = productAttributeValues;
    }
}
