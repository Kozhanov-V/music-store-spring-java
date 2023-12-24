package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Integer> {

    @Query("SELECT DISTINCT b FROM Brand b JOIN b.products p JOIN p.category c WHERE c.name = :categoryName")
    List<Brand> findBrandsByCategoryName(@Param("categoryName") String categoryName);

    public Optional<Brand> findByName(String name);
}
