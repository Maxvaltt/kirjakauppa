package com.example.kirjakauppa.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.micrometer.common.lang.NonNull;





@Controller
public class BookController {

    private final BookRepository bookRepository;

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
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute book newBook) {
        bookRepository.save(newBook);
        return "redirect:/booklist";
    }



    @PostMapping("/deletebook/{id}")
public String deleteBook(@PathVariable @NonNull Long id) {
    bookRepository.deleteById(id);
    return "redirect:/booklist";
}
}
