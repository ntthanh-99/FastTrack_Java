package com.thanhnt.coffee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok().body("Hello World!!");
    }
}
