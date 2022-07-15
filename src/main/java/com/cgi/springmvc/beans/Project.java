package com.cgi.springmvc.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="Project")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long project_id;

    @Column(name = "project_name")
    private String project_name;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;


    @Column(name = "projectDescription")
    private String projectDescription;

    @ManyToMany
    @JoinTable(name = "employees_projects", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"))
    private Collection<Employee> employees;

    public void addEmployee(Employee employee){
        if (employees.contains(employee)){
            return;
        }
        else{
            employees.add(employee);
        }
    }

}
