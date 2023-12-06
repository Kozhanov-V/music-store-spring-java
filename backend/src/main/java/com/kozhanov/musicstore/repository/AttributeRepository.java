package com.kozhanov.musicstore.repository;

import com.kozhanov.musicstore.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
}
