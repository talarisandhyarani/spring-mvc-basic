package com.cgi.springmvc.beans;
import lombok.Data;

@Data
public class EmployeeDTO {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String stateAbbr;
    private String zipCode;
    private String phoneNumber;
    private String activeProjects;
}
