package com.kozhanov.librarymanagement.controller;

import com.kozhanov.librarymanagement.DTO.BorrowedBookDto;
import com.kozhanov.librarymanagement.model.Book;
import com.kozhanov.librarymanagement.model.BorrowedBook;
import com.kozhanov.librarymanagement.model.Client;
import com.kozhanov.librarymanagement.service.BookService;
import com.kozhanov.librarymanagement.service.BorrowedBookService;
import com.kozhanov.librarymanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class LibraryWebController {

    private final ClientService clientService;
    private final BookService bookService;
    private final BorrowedBookService borrowedBookService;

    @Autowired
    public LibraryWebController(ClientService clientService, BookService bookService, BorrowedBookService borrowedBookService) {
        this.clientService = clientService;
        this.bookService = bookService;
        this.borrowedBookService = borrowedBookService;
    }

    @GetMapping("/")
    public String showMain() {
        return "takeBook";
    }

    @PostMapping("/borrowedBooks/save")
    public String saveBorrowedBook(@ModelAttribute BorrowedBookDto borrowedBookDto, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.findByTitle(borrowedBookDto.getBookTitle());
        Optional<Client> client = clientService.findByFullName(borrowedBookDto.getClientFullName());
        if(book.isPresent() && client.isPresent()){
            BorrowedBook borrowedBook = new BorrowedBook(client.get(),book.get(),borrowedBookDto.getBorrowDate());
            borrowedBookService.save(borrowedBook);
            redirectAttributes.addFlashAttribute("successMessage", "Книга успешно взята на прочтение!");
        }
        else{
            redirectAttributes.addFlashAttribute("errorMessage", "Неверно введено ФИО пользователя или название книги");
        }
        return "redirect:/";
    }
}
