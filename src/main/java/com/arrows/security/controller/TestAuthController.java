package com.arrows.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestAuthController {
    @GetMapping("/get")
    @PreAuthorize("hasAnyRole('ADMIN','INVITED')")
    public String helloGet() {
        return "Hello World - GET";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloPost() {
        return "Hello World - POST";
    }

    @PutMapping("/put")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloPut() {
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloDelete() {
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloPatch() {
        return "Hello World - PATCH";
    }
}
