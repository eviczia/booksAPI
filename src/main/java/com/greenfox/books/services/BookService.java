package com.greenfox.books.services;


import com.greenfox.books.models.entities.ReturnJSon;

public interface BookService {

    ReturnJSon processSearchTerm(String searchTerm);

    String keepBook(String bookId);

    ReturnJSon getMyBooks();
}
