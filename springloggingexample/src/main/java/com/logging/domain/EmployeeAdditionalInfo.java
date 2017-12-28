package com.logging.domain;

import com.logging.validator.group.EmployeeAddInfoCheck;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by Shikhar on 23-12-2017.
 */
@Data
public class EmployeeAdditionalInfo {

    String address;
    String town;
    String email;
    @NotNull(message = "Phone number can't be null",groups = EmployeeAddInfoCheck.class)
    String phoneNo;
}
