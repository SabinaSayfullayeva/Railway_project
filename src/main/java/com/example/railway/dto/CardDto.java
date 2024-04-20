package com.example.railway.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.example.railway.domain.Card}
 */
public record CardDto(
        String name,
        @NotNull
        @CreditCardNumber
        String cardNumber,
        Date expireDate,
        String pinCode,
         String userName
) implements Serializable {
}