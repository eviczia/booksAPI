package com.greenfox.books.controllers;

import com.greenfox.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        System.out.println("we just had a visitor");
        return ResponseEntity.status(200).body("Hello! Logged in users can access the google books api. Register if you are new here.");
    }
/*
    @GetMapping("/register")
    public ResponseEntity findBooksAnyone(@RequestBody ApplicationUser newUser) {
        applicationUserService.regoister(newUser);
        return ResponseEntity.status(300).body("redirect:/");
    }
*/
    @GetMapping("/all-books")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity search(@RequestParam(name = "q", required = false) String searchTerm) {
        if (searchTerm == null) return ResponseEntity.status(200).body("Well hello there");
        System.out.println("a user tried the google api function");
        return ResponseEntity.status(200).body(bookService.processSearchTerm(searchTerm));
    }

    @GetMapping("/my-books")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('my-books:read')")
    public ResponseEntity getMyBooks() {
        System.out.println("admin looked at the bookshelf contents");
        return ResponseEntity.status(200).body(bookService.getMyBooks());
    }

    @PostMapping("/my-books")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("hasAuthority('my-books:write')")
    public ResponseEntity addBook(@RequestParam(name = "id") String bookId) {
        System.out.println("admin added to the bookshelf");
        return ResponseEntity.status(200).body(bookService.keepBook(bookId));
    }
}
