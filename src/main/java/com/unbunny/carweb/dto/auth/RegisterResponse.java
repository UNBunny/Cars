package com.unbunny.carweb.dto.auth;

import java.util.UUID;

public class RegisterResponse {
    private final UUID id;
    private final String username;

    public RegisterResponse(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}