package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/demo")
    public String get() {
        return "greeting1";
    }
}