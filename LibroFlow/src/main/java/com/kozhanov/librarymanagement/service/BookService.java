package com.kozhanov.librarymanagement.service;

import com.kozhanov.librarymanagement.model.Book;
import com.kozhanov.librarymanagement.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface BookService {
    public Page<Book> findAll(Pageable pageable);
    public Optional<Book> findById(long id);
    public boolean saveOrUpdate(Book book);
    public Optional<Book> findByTitle(String title);
}
