package com.example.kirjakauppa.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.kirjakauppa.domain.book;
import com.example.kirjakauppa.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<book> getBooksRest() {
        return (List<book>) bookRepository.findAll();
    }

    @SuppressWarnings("null")
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<book> getBookByIdRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
    


}
