package com.kozhanov.librarymanagement.controller;

import com.kozhanov.librarymanagement.model.Book;
import com.kozhanov.librarymanagement.service.BookService;
import com.kozhanov.librarymanagement.validator.ISBNValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookWebController {

    private final BookService bookService;

    @Autowired
    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showBooks(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "16") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = bookService.findAll(pageable);

        model.addAttribute("bookList", bookPage.getContent());
        model.addAttribute("totalPages", bookPage.getTotalPages());
        model.addAttribute("currentPage", page);

        return "bookList";
    }
    @GetMapping("/add")
    public String addBook() {
        return "saveBook";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "saveBook";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Книга удалена или не найдена.");
            return "redirect:/books";
        }
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        boolean success = bookService.saveOrUpdate(book);
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "Книга успешно добавлена или обновлена.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Произошла ошибка. Проверьте введенные данные и попробуйте снова.");
        }
        return "redirect:/books";
    }



}
