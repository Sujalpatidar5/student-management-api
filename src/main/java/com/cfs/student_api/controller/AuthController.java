package com.cfs.student_api.controller;

import com.cfs.student_api.dto.LoginRequestDTO;
import com.cfs.student_api.entity.User;
import com.cfs.student_api.security.JwtUtil;
import com.cfs.student_api.service.UserService;
import io.jsonwebtoken.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;    // verifies username & pw
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    //Register user
    @PostMapping("/register")
    public User register (@RequestBody User user) {
        return userService.register(user);
    }

    //Login API -> JWT token return krega
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getUsername());
    }

}
