package com.example.userservice.controller;
import com.example.userservice.dto.*;
import com.example.userservice.service.UserService;
import com.example.userservice.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        var user = userService.registerUser(request);
        String token = jwtUtil.generateToken(user.getId(), user.getRole());
        return ResponseEntity.ok(new AuthResponse(token, user.getId(), user.getRole()));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        var user = userService.authenticate(request.getUsername(), request.getPassword());
        String token = jwtUtil.generateToken(user.getId(), user.getRole());
        return ResponseEntity.ok(new AuthResponse(token, user.getId(), user.getRole()));
    }
}

