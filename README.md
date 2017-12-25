# spring-boot-simpified
This Repository will have all the things related to spring boot.
springbootvalidator demo has a demo example tp show how to integrate spring validation with groups.
basically,Spring provides a validation framework to validate the incoming request body.
If you want your validations to run as shown in the demo for ex

Employee class has the following attributes 
    String firstName;
    @NotNull(message = "This unique no can't be null",groups = {EmployeeCheck.class})
    String uniqueIdentificationNo;
    String lastName;
    @NotNull(message = "Employee's additionalInfo can't be null",groups = EmployeeAddInfoCheck.class)
    @Valid
    EmployeeAdditionalInfo employeeAdditionalInfo;


So when the first rest url is consumed you can use postman the project will be hosted at 
localhost:8080/

The first controller is localhost:8080/employee
request body is 
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
