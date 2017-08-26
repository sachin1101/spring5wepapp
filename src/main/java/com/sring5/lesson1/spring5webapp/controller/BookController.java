package com.sring5.lesson1.spring5webapp.controller;

import com.sring5.lesson1.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController  {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books",this.bookRepository.findAll()   );

        return "books";
    }

}
