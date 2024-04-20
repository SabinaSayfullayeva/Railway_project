package com.example.railway.controller;

import com.example.railway.dto.user.UserLoginDTO;
import com.example.railway.dto.user.UserSignUpDTO;
import com.example.railway.dto.web.JwtTokenResponse;
import com.example.railway.service.impl.AuthServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "some",description = "some")
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthServiceImpl authServiceImpl;

    public AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<JwtTokenResponse> signUp(
         @RequestBody @Valid final UserSignUpDTO dto
    ) {
        return ResponseEntity.ok(authServiceImpl.signUp(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenResponse> login(
            @RequestBody @Valid UserLoginDTO dto
    ){
        return ResponseEntity.ok(authServiceImpl.login(dto));
    }
}
