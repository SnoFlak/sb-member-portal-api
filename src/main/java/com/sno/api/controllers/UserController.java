package com.sno.api.controllers;

import com.sno.api.dto.UserRegistrationRequest;
import com.sno.api.entries.UserEntry;
import com.sno.api.services.UserService;
import org.springframework.web.bind.annotation.*;

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
    //create user
//    @PostMapping("/create")
//    public UserEntry createUser(@RequestBody UserRegistrationRequest req) {
//
//    }

    //delete user

}
