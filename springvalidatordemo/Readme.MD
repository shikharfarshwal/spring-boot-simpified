#Spring-validator-with-groupings

If you want your validations to run as shown in the demo for ex

Employee class has the following attributes 
    
    String firstName;
    @NotNull(message = "This unique no can't be null",groups = {EmployeeCheck.class})
    String uniqueIdentificationNo;
    String lastName;
    @NotNull(message = "Employee's additionalInfo can't be null",groups = EmployeeAddInfoCheck.class)
    @Valid
    EmployeeAdditionalInfo employeeAdditionalInfo;
   
The application will be hosted at
localhost:8080/

1. First controller is localhost:8080/employee

Request body is

```
{
  "firstName": "*****",
  "uniqueIdentificationNo": null,
  "lastName": "********",
  "employeeAdditionalInfo": {
    "address": "############",
    "town": "@@@@@@@@@@@@@",
    "email": "s!!!!!!!!!!!!!!!!!!!!!!",
    "phoneNo": "876876876"
  }
}
```

only those validations will work which are tagged with group EmployeeCheck and EmployeeAddInfoCheck marker interface.
