package com.kozhanov.librarymanagement.repository;

import com.kozhanov.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> findByTitle(String title);
}
