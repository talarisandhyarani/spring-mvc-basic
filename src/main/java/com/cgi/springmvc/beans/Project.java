package com.cgi.springmvc.beans;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="projects")
@AllArgsConstructor
@NoArgsConstructor

    
public class Project {
    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable=false, length=50)
    private String projectName;

    @Column(nullable=false, length=50)
    private Date startDate;

    @Column(nullable=false, length=50)
    private Date endDate;

    @ManyToMany
    @JoinTable(name="employee_projects", 
        joinColumns = @JoinColumn(
            name="project_id",
            referencedColumnName = "project_id"),
        inverseJoinColumns = @JoinColumn(
            name="employee_id",
            referencedColumnName = "employee_id")
        )
    private Collection<Employee> employees;

    public void addEmployee(Employee employee){
        if(employees.contains(employee)){
            return;
        }
        else{
            employees.add(employee);
        }
    }

}