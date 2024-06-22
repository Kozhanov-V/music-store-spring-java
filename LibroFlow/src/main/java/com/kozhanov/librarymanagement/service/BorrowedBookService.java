package com.kozhanov.librarymanagement.service;

import com.kozhanov.librarymanagement.DTO.BorrowingInfoDto;
import com.kozhanov.librarymanagement.model.BorrowedBook;

import java.util.List;

public interface BorrowedBookService {
    public void save(BorrowedBook borrowedBook);
    public List<BorrowingInfoDto> findAllBorrowings();
}
