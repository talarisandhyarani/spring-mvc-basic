package com.cgi.springmvc.beans;

import java.sql.Date;

import lombok.Data;


@Data
public class ProjectDTO {
    private Long projectId;
    private String projectName;
    private Date startDate;
    private Date endDate;
}
