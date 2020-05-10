package com.greenfox.books.controllers;

import com.greenfox.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
public class MyBookController {

    private BookService bookService;

    @Autowired
    public MyBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity greetVisitor() {
        return ResponseEntity.status(200).body("Hello! Logged in users can access the google books api. Register if you are new here.");
    }
/*
    @GetMapping("/register")
    public ResponseEntity findBooksAnyone(@RequestBody ApplicationUser newUser) {
        applicationUserService.regoister(newUser);
        return ResponseEntity.status(300).body("redirect:/");
    }
*/
    @GetMapping("/user")
    public ResponseEntity findBooksUser(@RequestParam(name = "q", required = false) String searchTerm) {
        if (searchTerm == null) return ResponseEntity.status(200).body("Well hello there");
        return ResponseEntity.status(200).body(bookService.processSearchTerm(searchTerm));
    }
    @GetMapping("/admin")
    public ResponseEntity findBooksAdmin(@RequestParam(name = "q") String searchTerm) {
        return ResponseEntity.status(200).body(bookService.processSearchTerm(searchTerm));
    }
}
