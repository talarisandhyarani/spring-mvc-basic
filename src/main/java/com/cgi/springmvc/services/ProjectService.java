package com.cgi.springmvc.services;

import java.util.List;

import com.cgi.springmvc.beans.Project;

public interface ProjectService {
    public abstract void createProject(Project project);
    public abstract void updateProject(String id, Project project);
    public abstract void deleteProject(String id);
    public abstract List<Project> getProject();
}