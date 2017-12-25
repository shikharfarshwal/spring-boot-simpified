package com.example.validator;

import com.example.domain.Employee;
import com.example.excpetion.RequestBodyHasInvalidData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Shikhar on 23-12-2017.
 */
@Component
public class ValidatorImpl implements Validator<Employee,Class,Boolean> {
    @Override
    public Boolean validate(Employee employee, BindingResult bindingResult, Class... group) {
        javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Employee>> violations= validator.validate(employee, group);
        if(!CollectionUtils.isEmpty(violations)){
            for (ConstraintViolation<Employee> employeeConstraintViolation:
                 violations) {
                FieldError fieldError = new FieldError(
                        String.valueOf(employeeConstraintViolation.getPropertyPath()),
                        String.valueOf(employeeConstraintViolation.getInvalidValue()),
                        employeeConstraintViolation.getMessage()
                );
                bindingResult.addError(fieldError);
            }
            throw new RequestBodyHasInvalidData("Invalid data found in the request body!",bindingResult);
        }
        return Boolean.TRUE;
    }
}
