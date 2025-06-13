package com.unbunny.carweb.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RegisterResponse {
    private final UUID id;
    private final String username;
}