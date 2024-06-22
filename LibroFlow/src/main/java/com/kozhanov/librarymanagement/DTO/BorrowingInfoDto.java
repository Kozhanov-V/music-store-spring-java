package com.kozhanov.librarymanagement.DTO;

import java.time.LocalDate;

public class BorrowingInfoDto {
    private String clientFullName;
    private LocalDate clientBirthDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private LocalDate borrowingDate;

    public BorrowingInfoDto() {
    }

    public BorrowingInfoDto(String clientFullName, LocalDate clientBirthDate, String bookTitle, String bookAuthor, String bookIsbn, LocalDate borrowingDate) {
        this.clientFullName = clientFullName;
        this.clientBirthDate = clientBirthDate;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIsbn = bookIsbn;
        this.borrowingDate = borrowingDate;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public LocalDate getClientBirthDate() {
        return clientBirthDate;
    }

    public void setClientBirthDate(LocalDate clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}

