package com.sno.api.dto;

import java.util.UUID;

public record UserResponse (
        UUID publicId,
        String email
){}
