package com.sring5.lesson1.spring5webapp.controller;


import com.sring5.lesson1.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/Authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("Authors", this.authorRepository.findAll());
        return "authors";
    }
}
