package com.cgi.springmvc.services;

import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    public ProjectDTO getProjectById(long id){

        Project project = projectRepository.findById(id).orElse(null);

        return modelMapper.map(project,ProjectDTO.class);
    }

    public boolean addProject(ProjectDTO projectDTO){
        if (projectDTO == null || projectDTO.getProject_id() != 0){
            return false;
        }
        Project projectEntity = modelMapper.map(projectDTO, Project.class);
        projectRepository.save(projectEntity);
        return true;
    }

    public boolean deleteProject(long proj_id){
        if (proj_id == 0){
            return false;
        }
        projectRepository.deleteById(proj_id);
        return true;
    }

    public boolean updateProject(ProjectDTO projectDTO, boolean insert){
        if (projectDTO == null
                || (projectRepository.existsById(projectDTO.getProject_id()) && insert == false)){
            return false;
        }
        Project projectEntity = modelMapper.map(projectDTO, Project.class);
        projectRepository.save(projectEntity);

        return true;

    }

}
