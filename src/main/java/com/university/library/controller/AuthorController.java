package com.university.library.controller;

import com.university.library.model.Author;
import com.university.library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /** Displays the paginated list of all authors. */
    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors/list";
    }

    /** Opens a blank form for registering a new author. */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    /** Validates and persists an author record. */
    @PostMapping("/save")
    public String saveAuthor(@Valid @ModelAttribute("author") Author author,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "authors/form";
        }
        try {
            authorService.saveAuthor(author);
        } catch (Exception ex) {
            model.addAttribute("error",
                    "Unable to save author — the email address may already be in use.");
            return "authors/form";
        }
        return "redirect:/authors";
    }

    /** Loads an existing author into the form for editing. */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "authors/form";
    }
}
