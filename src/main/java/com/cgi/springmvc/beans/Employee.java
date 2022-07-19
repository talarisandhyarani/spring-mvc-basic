package com.cgi.springmvc.beans;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {

    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmployeeId;

    @Column(nullable=false, length=50)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

    @Column(nullable=false, length=95)
    private String streetAddress;

    @Column(nullable=false, length=35)
    private String city;

    @Column(nullable=false, length=2)
    private String stateAbbr;

    @Column(nullable=false, length=5)
    private String zipCode;

    @Column(nullable=false, length=10)
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="employee_projects",
        joinColumns = @JoinColumn(
            name = "employee_id",
            referencedColumnName = "employee_id"),
        inverseJoinColumns = @JoinColumn(
            name = "project_id",
            referencedColumnName = "project_id")
    )
    private Collection<Project> projects;

    public void addProject(Project project){
        if(projects.contains(project)){
            return;
        }
        else{
            projects.add(project);
        }
    }

}