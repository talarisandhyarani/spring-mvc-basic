package com.cgi.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.repository.ProjectRepository;

@Service

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void createProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void updateProject(String id, Project project) {
        
    }

    @Override
    public void deleteProject(String id) {
        
    }

    @Override
    public List<Project> getProject() {
        return projectRepository.values();
    }
    
}
