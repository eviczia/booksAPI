package com.greenfox.books.security;

public enum AppUserPermission {
    USER_READ("allbooks:read"),
//    USER_WRITE("user:write"),
    ADMIN_READ("my-books:read"),
    ADMIN_WRITE("my-books:write");

    private final String permission;

    AppUserPermission(String permission) {
    this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
