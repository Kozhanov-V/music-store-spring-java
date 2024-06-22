package com.kozhanov.librarymanagement.service;

import com.kozhanov.librarymanagement.model.Client;
import com.kozhanov.librarymanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public boolean saveOrUpdate(Client client) {
        if (client.getClientId() != null) {
            Optional<Client> existingClient = clientRepository.findById(client.getClientId());
            if (!existingClient.isPresent()) {
                return false; // Клиент не найден
            }
        }
        clientRepository.save(client);
        return true; // Успешно сохранено или обновлено
    }

    @Override
    public Optional<Client> findByFullName(String fullName) {
        return clientRepository.findByFullName(fullName);
    }
}
