package com.greenfox.books.models.entities;

public class ReturnJSon {

    private String kind;
    private Integer totalItems;

    public ReturnJSon(String kind, Integer totalItems) {
        this.kind = kind;
        this.totalItems = totalItems;
    }
}
