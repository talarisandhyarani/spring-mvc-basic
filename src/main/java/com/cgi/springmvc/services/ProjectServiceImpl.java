package com.cgi.springmvc.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.ProjectRepository;

@Service

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Project createProject(ProjectDTO project) {
        Project projectEntity = modelMapper.map(project, Project.class);
        return projectRepository.save(projectEntity);
    }

    

    @Override
    public void deleteProject(String id) {
        
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects= new ArrayList<Project>();
        projectRepository.findAll().forEach(projects::add);
        List<ProjectDTO> projectsDTO = modelMapper.map(projects, new TypeToken<List<ProjectDTO>>() {}.getType());
        return projectsDTO;
    }

    @Override
    public void updateProject(String id, ProjectDTO project) {
        
    }
}
