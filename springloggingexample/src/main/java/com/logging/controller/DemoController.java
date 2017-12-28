package com.logging.controller;

import com.logging.domain.Employee;
import com.logging.validator.Validator;
import com.logging.validator.group.EmployeeAddInfoCheck;
import com.logging.validator.group.EmployeeCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shikhar on 23-12-2017.
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    Validator validator;

    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee,BindingResult bindingResult) {
        log.debug("Going to validate the employee dto");
        validator.validate(employee,bindingResult, EmployeeCheck.class);
        return new ResponseEntity<Object>(employee, HttpStatus.ACCEPTED);
    }


    @PostMapping(value = "/update/employee/additional", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateEmployeeAddInfo(@RequestBody Employee employee,BindingResult bindingResult) {
        validator.validate(employee,bindingResult, EmployeeAddInfoCheck.class);
        return new ResponseEntity<Object>(employee, HttpStatus.ACCEPTED);
    }
}
