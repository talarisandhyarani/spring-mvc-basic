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
@Table(name="projects")

    
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable=false, length=50)
    private String projectName;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private Set<ActiveProject> activeProjects;

    protected Project(){}

    public Project(Long projectId, String projectName, Set<ActiveProject> activeProjects) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.activeProjects = activeProjects;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<ActiveProject> getActiveProjects() {
        return activeProjects;
    }

    public void setActiveProjects(Set<ActiveProject> activeProjects) {
        this.activeProjects = activeProjects;
    }

    
}
