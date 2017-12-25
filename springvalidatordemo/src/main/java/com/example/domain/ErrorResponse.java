package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Shikhar on 25-12-2017.
 */
@Data
@NoArgsConstructor
public class ErrorResponse {
    private Integer code;
    private String message;
    private final String timestamp = LocalDateTime.now().toString();
}
