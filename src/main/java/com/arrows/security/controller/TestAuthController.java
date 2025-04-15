package com.arrows.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {
    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet() {
        return "Hello World - GET";
    }

    @PostMapping("/post")
    public String helloPost() {
        return "Hello World - POST";
    }

    @PutMapping("/put")
    @PreAuthorize("hasAnyRole('ADMIN', 'INVITED')")
    public String helloPut() {
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('USER')")
    public String helloDelete() {
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    @PreAuthorize("hasAuthority('REFACTOR') or hasAuthority('DELETE')")
    public String helloPatch() {
        return "Hello World - PATCH";
    }
}
