package com.cgi.springmvc.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Nullable
    @Column(name = "address")
    private String address;

    @Nullable
    @Column(name = "email")
    private String email;

    @Nullable
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "employees_projects", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"))
    private List<Project> projects;

    @Nullable
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name="birthDay")
    private Date birthDay;

    @Nullable
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name="hireDate")
    private Date hireDate;


    public void addProject(Project project){
        if (projects.contains(project)){
            return;
        }
        else{
            projects.add(project);
        }
    }

}