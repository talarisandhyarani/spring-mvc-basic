package com.cgi.springmvc.beans;

import lombok.Data;

@Data
public class ActiveProjectDTO {
    private Long projectListId;
    private Employee employee;
    private Project project;
}
