package com.kozhanov.musicstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Integer getCategoryId() {
        return id;
    }

    public void setCategoryId(Integer id) {
        this.id = id;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addReviews(Product product) {
        if(products == null){
            products = new HashSet<>();
        }
        this.products.add(product);
    }
}

