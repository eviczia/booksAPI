package com.greenfox.books.controllers;

import com.greenfox.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBookController {

    private BookService bookService;

    @Autowired
    public MyBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity findBooksAnyone() {
        return ResponseEntity.status(200).body("who are you?");
    }
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
