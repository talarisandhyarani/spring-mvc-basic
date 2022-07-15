package com.cgi.springmvc.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private long project_id;
    private String project_name;
    private Date start_date;
    private Date end_date;

    @Override
    public String toString(){
        return "Project #: " + project_id +
                "\nName: " + project_name +
                "\nStart date: " + start_date.toString() +
                "\nEnd date: " + end_date.toString();
    }
}
