package com.example.validator;

import org.springframework.validation.BindingResult;

/**
 * Created by Shikhar on 23-12-2017.
 */
public interface Validator<T, U extends Class, Y> {

    Y validate(T data, BindingResult bindingResult, U... group);


}
