package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.demo.security.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/test")
    public String test() {
        return "Backend is working!";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (user.getRole() == null) {
            user.setRole("USER"); // fallback safety
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User registered successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        return userRepository.findFirstByUsername(user.getUsername())
                .map(existingUser -> {
                    if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {

                        String token = jwtUtil.generateToken(
                                existingUser.getUsername(),
                                existingUser.getRole()
                        );



                        return ResponseEntity.ok().body(
                                Map.of(
                                        "message", "Login successful",
                                        "token", token,
                                        "username", existingUser.getUsername(),
                                        "role", existingUser.getRole()
                                )
                        );

                    } else {
                        return ResponseEntity.status(401).body(
                                Map.of("error", "Invalid password")
                        );
                    }
                })
                .orElse(ResponseEntity.status(404).body(
                        Map.of("error", "User not found")
                ));
    }

    @GetMapping("/secure")
    public String secure() {
        return "You are authenticated!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin access";
    }




}