package com.sno.api.controllers;

import com.sno.api.dto.UserRegistrationRequest;
import com.sno.api.dto.UserResponse;
import com.sno.api.entries.UserEntry;
import com.sno.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getHome() {
        return "Hello!";
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationRequest req) {
        userService.createUser(req);
        return ResponseEntity.ok("User registered successfully and password hashed!");
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID publicId) {
        UserEntry user = userService.getUser(publicId);
        return ResponseEntity.ok(new UserResponse(user.getPublicId(), user.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRegistrationRequest req) throws Exception {
        UserResponse response = userService.loginUser(req);
        return ResponseEntity.ok(response);
    }
}
