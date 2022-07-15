package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.Project;
import com.cgi.springmvc.beans.ProjectDTO;
import com.cgi.springmvc.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class ProjectController {
    @Autowired
    private ProjectRepository projectRep;

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


}
