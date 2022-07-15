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
    private Collection<Project> Projects;

    @Nullable
    @Column(name="birthDate")
    private Date birthDate;

    @Nullable
    @Column(name="hireDate")
    private Date hireDate;

}