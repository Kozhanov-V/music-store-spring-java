package com.kozhanov.musicstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "attribute")
    @JsonManagedReference
    private Set<AttributeValue> attributeValues;

    @OneToMany(mappedBy = "attribute")
    private Set<CategoryAttribute> categoryAttributes;

    public Set<CategoryAttribute> getCategoryAttributes() {
        return categoryAttributes;
    }

    public void setCategoryAttributes(Set<CategoryAttribute> categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Set<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}

