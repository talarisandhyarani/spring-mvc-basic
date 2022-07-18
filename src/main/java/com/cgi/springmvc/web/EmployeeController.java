package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/newEmployee")
    public String newEmployee(){
        return "newEmployee";
    }

    @PostMapping(value = "/newEmployee")
    public String saveEmployee(RedirectAttributes redirectAttributes, @ModelAttribute("employee") EmployeeDTO employee){
        System.out.println("employee name " + employee.getFirstName());

        Employee newEmployee = employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("employee", newEmployee);

        return "redirect:employeeDetails";
    }

    @GetMapping("/employeeDetails")
    public String getEmployee(@ModelAttribute("employee") Employee employee, Model model) {

        model.addAttribute("message", "Hello "+employee.getFirstName()+ "!");
        model.addAttribute("employee", employee);
        return "employeeDetails";
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable("id") Long employeeId, Model model){
        EmployeeDTO employee = employeeService.getEmployeeById(employeeId);

        model.addAttribute("employee", employee);
        return "employeeDetails";
    }

    @GetMapping("/employeeList")
    public String getEmployees( Model model) {
        List<EmployeeDTO> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employeeList";
    }

    @GetMapping("/searchEmployee")
    public String searchEmployee(){
        return "searchEmployee";
    }

    @PostMapping("/searchEmployee")
    public String searchReturn(@RequestParam String query, Model model) {
        List<Employee> employees = new ArrayList<Employee>();
        query = "%" + query + "%";
        System.out.println("query " + query);
        employees = employeeService.getEmployeeByKeyword(query);

        if (!employees.isEmpty()) {
            model.addAttribute("employees", employees);
            return "searchResults";
        }
        return "searchEmployee";
    }

    @GetMapping("/searchResults")
    public String getSearch( Model model) {
        return "searchResults";
    }

    @GetMapping("/getDeleteEmployeeForm")
    public String getDeleteEmployeeForm(Model model){
        model.addAttribute("result", false);
        return "deleteEmployee";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") Long id, Model model){
        boolean deleteSuccess = employeeService.deleteById(id);

        if(deleteSuccess)
            model.addAttribute("result", deleteSuccess);
        return "deleteEmployee";

    }

}
