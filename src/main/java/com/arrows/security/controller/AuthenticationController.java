package com.arrows.security.controller;

import com.arrows.security.controller.dto.AuthCreateUserRequest;
import com.arrows.security.controller.dto.AuthLoginRequest;
import com.arrows.security.controller.dto.AuthResponse;
import com.arrows.security.service.UserDetailServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserDetailServiceImpl userDetailService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest) {
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUser){
        return new ResponseEntity<>(this.userDetailService.registerUser(authCreateUser), HttpStatus.OK);
    }

}
