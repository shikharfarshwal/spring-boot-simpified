package com.example.domain;

import com.example.validator.group.EmployeeAddInfoCheck;
import com.example.validator.group.EmployeeCheck;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Shikhar on 23-12-2017.
 */
@Data
public class Employee {

    String firstName;
    @NotNull(message = "This unique no can't be null",groups = {EmployeeCheck.class})
    String uniqueIdentificationNo;
    String lastName;

    @NotNull(message = "Employee's additionalInfo can't be null",groups = EmployeeAddInfoCheck.class)
    @Valid
    EmployeeAdditionalInfo employeeAdditionalInfo;
}
