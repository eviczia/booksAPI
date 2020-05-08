package com.greenfox.books.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Volume {

    @JsonIgnore
    @Id
    private String id;
    @OneToOne
    private VolumeInfo volumeInfo;
/*    private String title;
    @ElementCollection
    private List<String> authors;
    private String description;
    private String typeIdentifier;*/


    public Volume() {
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
