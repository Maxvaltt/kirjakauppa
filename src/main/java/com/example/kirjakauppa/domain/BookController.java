package com.example.kirjakauppa.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<book> books = bookRepository.findAll(); // Fetch all books from the database
        model.addAttribute("books", books); // Add books to the model
        return "booklist"; // Return the name of the Thymeleaf template
    }

        @GetMapping("/addbooks")
    public String showAddBookForm(Model model) {
        model.addAttribute("newBook", new book());
        return "addbooks";
    }

    @PostMapping("/addbooks")
    public String addBook(@ModelAttribute book newBook) {
        // Save the new book to the database
        bookRepository.save(newBook);
        return "redirect:/booklist";
    }
    }
