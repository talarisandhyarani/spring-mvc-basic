package com.cgi.springmvc.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="activeProjects")

public class ActiveProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectListId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employeeId", nullable = false) 
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "projectId", nullable = false) 
    private Project project;

    protected ActiveProject(){}

    public ActiveProject(Long projectListId, Employee employee, Project project) {
        this.projectListId = projectListId;
        this.employee = employee;
        this.project = project;
    }

    public Long getProjectListId() {
        return projectListId;
    }

    public void setProjectListId(Long projectListId) {
        this.projectListId = projectListId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    

    
}
