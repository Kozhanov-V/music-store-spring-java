package com.kozhanov.librarymanagement.repository;

import com.kozhanov.librarymanagement.DTO.BorrowingInfoDto;
import com.kozhanov.librarymanagement.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook,Long> {
    @Query("SELECT new com.kozhanov.librarymanagement.DTO.BorrowingInfoDto(c.fullName, c.birthDate, b.title, b.author, b.isbn, bb.borrowedDate) " +
            "FROM BorrowedBook bb " +
            "JOIN bb.client c " +
            "JOIN bb.book b")
    List<BorrowingInfoDto> findAllBorrowings();
}
