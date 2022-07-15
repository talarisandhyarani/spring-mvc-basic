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
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
}
