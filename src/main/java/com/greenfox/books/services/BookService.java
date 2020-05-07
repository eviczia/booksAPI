package com.greenfox.books.services;


import com.greenfox.books.models.entities.Volume;

import java.util.List;

public interface BookService {
    List<Volume> processSearchTerm(String searchTerm);
}
