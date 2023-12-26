package com.kozhanov.musicstore.specifications;

import com.kozhanov.musicstore.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSpecifications {

    public static Specification<Product> byCategory(String categoryName) {
        return (root, query, criteriaBuilder) -> {
            if (categoryName == null || categoryName.isEmpty()) return null;
            return criteriaBuilder.equal(root.get("category").get("name"), categoryName);
        };
    }

    public static Specification<Product> byBrand(List<Brand> brands) {
        return (root, query, criteriaBuilder) -> {
            if (brands == null || brands.isEmpty()) return null;
            CriteriaBuilder.In<String> inClause = criteriaBuilder.in(root.get("brand").get("name"));
            for (Brand brand : brands) {
                inClause.value(brand.getName());
            }
            return inClause;
        };
    }


    public static Specification<Product> priceInRange(int minPrice, int maxPrice) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
        };
    }


    public static Specification<Product> withDiscount(boolean withDiscount) {
        return (root, query, criteriaBuilder) -> {
            if (withDiscount) {
                return criteriaBuilder.greaterThan(root.get("discounts"), 0);
            } else {
                return criteriaBuilder.equal(root.get("discounts"), 0);
            }
        };
    }


    public static Specification<Product> byAttributes(HashMap<String, List<String>> attributes) {
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (attributes == null || attributes.isEmpty()) {
                return null;
            }

            List<Predicate> predicates = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
                List<String> values = entry.getValue();
                if (values == null || values.isEmpty()) {
                    continue;
                }

                Join<Product, ProductAttributeValue> productAttributeValueJoin = root.join("productAttributeValues");
                Join<ProductAttributeValue, AttributeValue> attributeValueJoin = productAttributeValueJoin.join("attributeValue");
                Join<AttributeValue, Attribute> attributeJoin = attributeValueJoin.join("attribute");

                CriteriaBuilder.In<String> inClause = criteriaBuilder.in(attributeValueJoin.get("value"));
                for (String value : values) {
                    inClause = inClause.value(value);
                }

                predicates.add(criteriaBuilder.and(
                        criteriaBuilder.equal(attributeJoin.get("name"), entry.getKey()),
                        inClause
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }




}
