package com.kozhanov.librarymanagement.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrowed_books",indexes = {
        @Index(name = "idx_borrowed_books_client_id", columnList = "client_id"),
        @Index(name = "idx_borrowed_books_book_id", columnList = "book_id")
})
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowed_id")
    private Long borrowedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "borrowed_date",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowedDate;

    public BorrowedBook() {
    }

    public BorrowedBook(Client client, Book book, LocalDate borrowedDate) {
        this.client = client;
        this.book = book;
        this.borrowedDate = borrowedDate;
    }

    public Long getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(Long borrowedId) {
        this.borrowedId = borrowedId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
}

