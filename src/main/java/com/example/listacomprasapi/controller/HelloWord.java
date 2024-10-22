package com.example.listacomprasapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="HelloWord")
@RestController
@RequestMapping("/")
public class HelloWord {
    @GetMapping("/")
    public ResponseEntity<String> Hello() {
        return ResponseEntity.ok("Hello World");
    }
}
