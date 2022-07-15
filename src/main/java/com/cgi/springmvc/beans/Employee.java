package com.cgi.springmvc.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

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

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private Set<ActiveProject> activeProjects;

    protected Employee(){}

    public Employee(Long employeeId, String firstName, String lastName, String streetAddress, String city,
            String stateAbbr, String zipCode, String phoneNumber, Set<ActiveProject> activeProjects) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateAbbr = stateAbbr;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.activeProjects = activeProjects;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<ActiveProject> getActiveProjects() {
        return activeProjects;
    }

    public void setActiveProjects(Set<ActiveProject> activeProjects) {
        this.activeProjects = activeProjects;
    }


}