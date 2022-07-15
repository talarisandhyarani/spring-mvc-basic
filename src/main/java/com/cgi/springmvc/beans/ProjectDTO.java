package com.cgi.springmvc.beans;


import java.sql.Date;
import java.util.Set;

import lombok.Data;


@Data
public class ProjectDTO {
    private long project_id;
    private String project_name;
    private Date start_date;
    private Date end_date;
    private Set<ActiveProject> activeProjects;
}
