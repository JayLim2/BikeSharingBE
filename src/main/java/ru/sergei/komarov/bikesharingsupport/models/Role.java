package ru.sergei.komarov.bikesharingsupport.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN, CLIENT, SUPPORT;

    @Override
    public String getAuthority() {
        return name();
    }
}
