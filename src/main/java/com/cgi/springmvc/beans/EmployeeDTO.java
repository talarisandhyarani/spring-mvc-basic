package com.cgi.springmvc.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private long EmployeeId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String stateAbbr;
    private String zipCode;
    private String phoneNumber;
    
}
