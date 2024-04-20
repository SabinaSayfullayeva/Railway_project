package com.example.railway.service;


import com.example.railway.dto.user.UserDTO;

public interface UserService {
    UserDTO getById(Long id);
}
