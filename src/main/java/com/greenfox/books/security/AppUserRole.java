package com.greenfox.books.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.greenfox.books.security.AppUserPermission.*;

public enum AppUserRole {
    USER(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, ADMIN_READ, ADMIN_WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
