package com.greenfox.books.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class VolumeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ElementCollection
    private List<String> authors;
    private String description;
/*    private String type;
    private String identifier;*/

    public VolumeInfo() {
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