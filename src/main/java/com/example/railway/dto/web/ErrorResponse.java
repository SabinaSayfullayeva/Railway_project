package com.example.railway.dto.web;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private String errorConde;

    private String errorMessage;

    private Object body;

    private String path;

    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();
}
