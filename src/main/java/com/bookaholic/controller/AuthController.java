package com.bookaholic.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @GetMapping("/test")
    public String test() {
        return "Backend is working! 🚀";
    }
}