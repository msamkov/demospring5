package ru.multicon.demospring5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.multicon.demospring5.repositories.BookRepository;


@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBook(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
