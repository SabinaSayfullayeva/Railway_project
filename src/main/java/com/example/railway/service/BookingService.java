package com.example.railway.service;

import com.example.railway.config.security.JwtTokenFilter;
import com.example.railway.dto.web.JwtTokenResponse;

public interface BookingService {
    JwtTokenResponse searching(String massage);
}
