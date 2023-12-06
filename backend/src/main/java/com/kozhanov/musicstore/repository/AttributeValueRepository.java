package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Integer> {
    public List<AttributeValue> findByAttributeId(int id);
}
