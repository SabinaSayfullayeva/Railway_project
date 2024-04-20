package com.example.railway.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


public record UserLoginDTO(
        @Email String email,
       // @NotBlank @Length(message = "8", min = 8, max = 255)
        String password){
}