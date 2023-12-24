package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    public List<Product> findByCategory_Name(String name);

    List<Product> findAll(Specification<Product> spec);
}
