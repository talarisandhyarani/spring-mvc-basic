package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.ProjectRepository;
import com.cgi.springmvc.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


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
    
    @GetMapping("/getEmployeeProjectForm")
    public String getEmployeeProjectForm(Model model){
        model.addAttribute("failure", false);
        return "addEmployeeToProjectForm";
    }

    @GetMapping("/getEmployeeProjectFormFailure")
    public String getEmployeeProjectFormFailure(Model model){
        model.addAttribute("failure", true);
        return "addEmployeeToProjectForm";
    }

    @PostMapping("/addEmployeeToProject")
    public RedirectView addEmployeeProject(@RequestParam("projectId") Long proj_id, @RequestParam("employId") Long employ_id){
        boolean insertionSuccess =  projectService.addEmployeeToProject(proj_id, employ_id);
        if (insertionSuccess) {
            return new RedirectView("");
        }
        else{
            return new RedirectView("/getEmployeeProjectFormFailure");
        }
    }

    //for testing projectService only changed to private now
    @PostMapping("/addToProjectAPI/")
    private boolean addToProjectAPI(@Param("cid") long cid, @Param("pid") long pid){
        projectService.addEmployeeToProject(pid, cid);
        return true;
    }

}
