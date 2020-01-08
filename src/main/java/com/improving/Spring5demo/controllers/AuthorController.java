package com.improving.Spring5demo.controllers;

import com.improving.Spring5demo.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepo.findAll());
        return "authors";
    }
}
