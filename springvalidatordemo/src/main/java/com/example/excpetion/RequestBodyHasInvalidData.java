package com.example.excpetion;

import lombok.Getter;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * Created by Shikhar on 25-12-2017.
 */
@Getter
public class RequestBodyHasInvalidData extends RuntimeException implements Serializable {

    private Errors errors;

    public RequestBodyHasInvalidData(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
