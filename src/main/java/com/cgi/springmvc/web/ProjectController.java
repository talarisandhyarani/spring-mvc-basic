package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.ProjectRepository;
import com.cgi.springmvc.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
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
    public String projectDetails() {
        return "projectDetails";
    }

    @DeleteMapping("/projectDetails")
    public String projectDelete(RedirectAttributes redirectAttr) {
        //insert logic here

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

    @PostMapping("/addToProject/{cid}/{pid}")
    public boolean addToProject(@PathVariable("cid") long cid, @PathVariable("pid") long pid){
        projectService.addEmployeeToProject(pid, cid);
        return true;
    }

}
