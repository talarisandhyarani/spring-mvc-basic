package com.cgi.springmvc.services;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.EmployeeRepository;
import com.cgi.springmvc.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ProjectService(EmployeeRepository employeeRepository, ProjectRepository projectRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
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

    public boolean addEmployeeToProject(long proj_id, long employ_id){
        Project project = projectRepository.findById(proj_id).orElse(null);
        Employee employee = employeeRepository.findById(employ_id).orElse(null);
        if (employee == null || project == null){
            return false;
        }
        project.addEmployee(employee);
        projectRepository.save(project);

        return true;
    }

    public List<ProjectDTO> getAllProjects(){
        List<Project> projects = new ArrayList<Project>();
        projectRepository.findAll().forEach(projects::add);
        List<ProjectDTO>  projectsDTO = modelMapper.map(projects, new TypeToken<List<ProjectDTO>>() {}.getType());
        return projectsDTO;
    }
}
