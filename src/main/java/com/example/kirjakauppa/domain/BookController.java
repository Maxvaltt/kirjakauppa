package com.example.kirjakauppa.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.micrometer.common.lang.NonNull;




@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new book());
        model.addAttribute("categories",categoryRepository.findAll());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute book newBook) {
        bookRepository.save(newBook);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Optional<book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            model.addAttribute("categories",categoryRepository.findAll());
            return "editbook";
        } else {
            return "redirect:/booklist";
        }
    }

    @SuppressWarnings("null")
    @PostMapping("/updatebook")
    public String updateBook(@ModelAttribute @NonNull book updatedBook) {
        bookRepository.save(updatedBook);
        return "redirect:/booklist";
    }
}
