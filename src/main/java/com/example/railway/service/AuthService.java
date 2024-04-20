package com.example.railway.service;


import com.example.railway.dto.user.UserLoginDTO;
import com.example.railway.dto.user.UserSignUpDTO;
import com.example.railway.dto.web.JwtTokenResponse;

public interface AuthService {
    JwtTokenResponse login(UserLoginDTO dto);

    JwtTokenResponse signUp(UserSignUpDTO dto);
}
