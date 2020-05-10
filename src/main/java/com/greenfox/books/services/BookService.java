package com.greenfox.books.services;


import com.greenfox.books.models.entities.ReturnJSon;
import com.greenfox.books.models.entities.Volume;

public interface BookService {

    ReturnJSon processSearchTerm(String searchTerm);

    Volume getBookByIdFromGoogleAPI(String volumeId);

    String keepBook(String bookId);

    ReturnJSon getMyBooks();
}
