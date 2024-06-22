package com.kozhanov.librarymanagement.repository;

import com.kozhanov.librarymanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    public Optional<Client> findByFullName(String fullName);
}
