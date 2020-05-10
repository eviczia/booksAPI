package com.greenfox.books.models.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class VolumeInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime id;
    private String title;
    @ElementCollection
    private List<String> authors;
    private String description;

    public VolumeInfo() {
        id = LocalDateTime.now();
    }

    public VolumeInfo(String title, List<String> authors, String description) {
        id = LocalDateTime.now();
        this.title = title;
        this.authors = authors;
        this.description = description;
    }

    public LocalDateTime getId() {
        return id;
    }

    public void setId(LocalDateTime id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
