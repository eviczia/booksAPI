package com.greenfox.books.models.entities;

public class User {

    private String login;
    private String url;

    public User(String login, String url) {
        this.login = login;
        this.url = url;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
