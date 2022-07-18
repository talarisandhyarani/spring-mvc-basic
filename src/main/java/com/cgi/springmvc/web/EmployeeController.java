package com.cgi.springmvc.web;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        Employee newEmployee =employeeService.saveEmployee(employee);
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
    public String searchReturn(@RequestParam String searchType, @RequestParam String query, Model model){
        EmployeeDTO employee = new EmployeeDTO();
        if (searchType.equals("name")){
            System.out.println("query " + query);
            String[] nameArr = query.split("\\s", 2);
            System.out.println("nameArr[0] " + nameArr[0]);
            System.out.println("nameArr[1] " + nameArr[1]);
            employee = employeeService.getEmployeeByName(nameArr[0], nameArr[1]);
        }else if (searchType.equals("email")){
            employee = employeeService.getEmployeeByEmail(query);
        }
        else if (searchType.equals("address")){
            employee = employeeService.getEmployeeByAddress(query);
        }
        else if (searchType.equals("phoneNum")){
            employee = employeeService.getEmployeeByPhoneNum(query);
        }
//      Adding result to the model regardless, so that JSP can check for null result to display error.
        model.addAttribute("employee", employee);
        return "searchEmployee";
    }
}
