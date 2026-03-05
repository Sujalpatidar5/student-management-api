package com.cfs.student_api.controller;

import com.cfs.student_api.entity.User;
import com.cfs.student_api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register (@RequestBody User user) {
        return userService.register(user);
    }
}
