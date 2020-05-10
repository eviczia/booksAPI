package com.greenfox.books.models.entities;

import java.util.List;

public class ReturnJSon {

    private String kind;
    private Integer totalItems;
    private List<Volume> items;

    public ReturnJSon(String kind, Integer totalItems, List<Volume> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public ReturnJSon() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Volume> getItems() {
        return items;
    }

    public void setItems(List<Volume> items) {
        this.items = items;
    }
}
