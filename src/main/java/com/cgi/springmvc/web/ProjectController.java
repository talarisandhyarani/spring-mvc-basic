package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.ProjectRepository;
import com.cgi.springmvc.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@org.springframework.stereotype.Controller
public class ProjectController {
    @Autowired
    private ProjectRepository projectRep;

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/newProject")
    public String newProject() {
        return "newProject";
    }

    @PostMapping("/newProject")
    public String submittedNewProject(RedirectAttributes redirectAttr, @ModelAttribute("project") ProjectDTO project) {
        Project projectEntity = modelMapper.map(project, Project.class);

        redirectAttr.addFlashAttribute("project", project);

        return "redirect:projectDetails";
    }

    @GetMapping("/projectDetails")
    public String projectDetails(@ModelAttribute("project") ProjectDTO project, Model model) {
        model.addAttribute("project", project);
        return "projectDetails";
    }

    @GetMapping("/projectDetails/{pid}/delete")
    public String projectDelete(RedirectAttributes redirectAttr, @PathVariable("pid") long pid) {
        projectService.deleteProject(pid);

        return "redirect:welcome";
    }

    @GetMapping("/editProjectEmployees")
    public String editProjectEmployees() {
        return "editProjectEmployees";
    }

    @PostMapping("/editProjectEmployees")
    public String submittedEditProjectEmployees(RedirectAttributes redirectAttr) {
        //Insert logic here

        return "redirect:projectDetails";
    }

    @GetMapping("/projectList")
    public String getProjectList(Model model) {
        List<ProjectDTO> projList = projectService.getAllProjects();
        model.addAttribute("projects", projList);

        return "projectList";
    }
    
    @GetMapping("/getEmployeeProjectForm")
    public String getEmployeeProjectForm(){
        return "addEmployeeToProjectForm";
    }

    @PostMapping("/addEmployeeToProject")
    public String addEmployeeProject(@RequestParam("projectId") Long proj_id, @RequestParam("employId") Long employ_id){
        projectService.addEmployeeToProject(proj_id, employ_id);
        return "redirect:";
    }

    //for testing projectService only changed to private now
    @PostMapping("/addToProjectAPI/")
    private boolean addToProjectAPI(@Param("cid") long cid, @Param("pid") long pid){

        projectService.addEmployeeToProject(pid, cid);
        return true;
    }

}
