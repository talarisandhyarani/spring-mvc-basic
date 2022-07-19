package com.cgi.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")

public class ProjectController {
    @Autowired
    private ProjectService projectService;
    
    @PostMapping("/getProject/")
    List<ProjectDTO> getProject(){
        return projectService.getAllProjects();
    }

    @PostMapping("/projects/")
    List<ProjectDTO> createProject(@RequestBody ProjectDTO project){
        projectService.createProject(project);
        return projectService.getAllProjects();
    }
}
