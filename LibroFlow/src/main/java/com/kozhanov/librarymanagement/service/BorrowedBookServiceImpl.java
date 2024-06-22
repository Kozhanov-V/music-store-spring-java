package com.kozhanov.librarymanagement.service;

import com.kozhanov.librarymanagement.DTO.BorrowingInfoDto;
import com.kozhanov.librarymanagement.model.BorrowedBook;
import com.kozhanov.librarymanagement.repository.BorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService{
    private final BorrowedBookRepository borrowedBookRepository;

    @Autowired
    public BorrowedBookServiceImpl(BorrowedBookRepository borrowedBookRepository) {
        this.borrowedBookRepository = borrowedBookRepository;
    }

    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public List<BorrowingInfoDto> findAllBorrowings() {
        return borrowedBookRepository.findAllBorrowings();
    }
}
