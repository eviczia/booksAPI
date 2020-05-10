package com.greenfox.books.repositories;

import com.greenfox.books.models.entities.Volume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Volume, String> {



    List<Volume> findAll();

}
