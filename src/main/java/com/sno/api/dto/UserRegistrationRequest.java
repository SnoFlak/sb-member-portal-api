package com.sno.api.dto;

public record UserRegistrationRequest(
        String email,
        String password
) {}
