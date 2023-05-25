package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Test2 {
    @GetMapping("/random")
    public ResponseEntity<String> random() {
        boolean valore = new Random().nextBoolean();
        if (valore) {
            return ResponseEntity.status(200).body("OK");
        } else return ResponseEntity.status(400).body("Bad Request");
    }
}
