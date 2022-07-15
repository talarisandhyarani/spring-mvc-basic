package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/newEmployee")
    public String newEmployee(){return "newEmployee";}

    @PostMapping(value = "/newEmployee")
    public String saveEmployee(RedirectAttributes redirectAttributes, @ModelAttribute("employee") EmployeeDTO employee){

        Employee newEmployee = employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("employee", newEmployee);

        return "redirect:employeeDetails";
    }

    @GetMapping("/employeeDetails")
    public String getEmployee(@ModelAttribute("employee") Employee employee, Model model) {

        model.addAttribute("message", "Hello "+employee.getFirstName()+ "!");
        model.addAttribute("employee", employee);
        return "employee";
    }

//    @GetMapping("/employee/{id}")
//    public String getEmployee(@PathVariable("id") Long employeeId, Model model){
//        Employee employee = employeeService.getEmployee(employeeId);
//
//        model.addAttribute("employee", employee);
//        return "employee";
//    }
//
//    @GetMapping("/employeeList")
//    public String getEmployees( Model model) {
//        List<Employee> employeeList = employeeService.getAllEmployee();
//        model.addAttribute("employees", employeeList);
//        return "employeeList";
//    }
}
