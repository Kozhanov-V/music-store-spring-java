package com.kozhanov.librarymanagement.service;

import com.kozhanov.librarymanagement.model.Book;
import com.kozhanov.librarymanagement.repository.BookRepository;
import com.kozhanov.librarymanagement.validator.ISBNValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    

    @Override
    public boolean saveOrUpdate(Book book) {
        if (!ISBNValidator.isValidISBN(book.getIsbn())) {
            return false;
        }

        if (book.getBookId() != null) {
            Optional<Book> existingBook = bookRepository.findById(book.getBookId());
            if (!existingBook.isPresent()) {
                return false;
            }
        }

        bookRepository.save(book);
        return true;
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
