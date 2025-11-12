package com.bookaholic.controller;


import com.bookaholic.DTO.LoginDTO;
import com.bookaholic.DTO.RegisterDTO;
import com.bookaholic.DTO.UserReadOnlyDTO;
import com.bookaholic.mapper.UserMapper;
import com.bookaholic.model.User;
import com.bookaholic.security.JwtUtil;
import com.bookaholic.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDTO) {
        try {
            User user = userMapper.mapToUserEntity(registerDTO);
            User savedUser = userService.save(user);
            UserReadOnlyDTO response = userMapper.mapToUserReadOnlyDTO(savedUser);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.login(loginDTO.getUsername(), loginDTO.getPassword());
            String token = jwtUtil.generateToken(user.getUsername());

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", userMapper.mapToUserReadOnlyDTO(user));

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

