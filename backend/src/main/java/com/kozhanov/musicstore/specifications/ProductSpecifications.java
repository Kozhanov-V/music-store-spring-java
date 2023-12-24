package com.kozhanov.musicstore.specifications;

import com.kozhanov.musicstore.model.AttributeValue;
import com.kozhanov.musicstore.model.Brand;
import com.kozhanov.musicstore.model.Product;
import com.kozhanov.musicstore.model.ProductAttributeValue;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
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
        return (root, query, criteriaBuilder) -> {
            if (attributes == null || attributes.isEmpty()) return null;

            List<Predicate> predicates = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
                if (!(entry.getValue() instanceof List)) {
                    // Обработка ошибки или логирование
                    continue;
                }

                List<String> values = entry.getValue();
                Join<Product, ProductAttributeValue> attributeValueJoin = root.join("productAttributeValues");
                Join<ProductAttributeValue, AttributeValue> attributeJoin = attributeValueJoin.join("attributeValue");

                CriteriaBuilder.In<String> inClause = criteriaBuilder.in(attributeJoin.get("value"));
                for (String value : values) {
                    inClause.value(value);
                }

                predicates.add(criteriaBuilder.and(
                        criteriaBuilder.equal(attributeJoin.get("attribute").get("name"), entry.getKey()),
                        inClause
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }




}
