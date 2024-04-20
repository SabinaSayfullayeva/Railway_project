package com.example.railway.dto.user;


import com.example.railway.domain.User;

public record UserDTO(
        Long id,
        String username,
        String email,
        long roles
)  {

    public static UserDTO from(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles()
        );
    }
}