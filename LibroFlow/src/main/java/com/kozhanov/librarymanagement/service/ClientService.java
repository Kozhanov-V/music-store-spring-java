package com.kozhanov.librarymanagement.service;

import com.kozhanov.librarymanagement.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface ClientService {
    public Optional<Client> findById(long id);
    public Page<Client> findAll(Pageable pageable);
    public boolean saveOrUpdate(Client client);
    public Optional<Client> findByFullName(String fullName);
}
