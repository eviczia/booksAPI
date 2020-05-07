package com.greenfox.books.models.dtos;

import com.greenfox.books.models.entities.Volume;

import java.util.List;

public class Volumes {

    private List<Volume> volumes;

    public Volumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    public Volumes() {
    }
}
