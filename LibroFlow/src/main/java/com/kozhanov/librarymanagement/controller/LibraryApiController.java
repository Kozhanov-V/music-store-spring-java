package com.kozhanov.librarymanagement.controller;


import com.kozhanov.librarymanagement.DTO.BorrowingInfoDto;
import com.kozhanov.librarymanagement.service.BorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryApiController {
    private final BorrowedBookService borrowedBookService;

    @Autowired
    public LibraryApiController(BorrowedBookService borrowedBookService) {
        this.borrowedBookService = borrowedBookService;
    }

    @GetMapping("/borrowings")
    public ResponseEntity<?> getAllBorrowings() {
        return new ResponseEntity<>(borrowedBookService.findAllBorrowings(), HttpStatus.OK);
    }
}
