package com.kozhanov.librarymanagement.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BorrowedBookDto {
    private String clientFullName;
    private String bookTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowDate;

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}
