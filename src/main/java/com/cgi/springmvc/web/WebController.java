package com.cgi.springmvc.web;


import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@org.springframework.stereotype.Controller
public class WebController {

      @Autowired
   private EmployeeRepository employeeRep;
      @Autowired
   private ModelMapper modelMapper;
   /* @Autowired
    public WebController(CustomerRepository customerRepository){
        this.customerRep = customerRepository;
    }*/


    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }

    @GetMapping("/sample2")
    public String showForm2() {
        return "sample2";
    }

    @GetMapping("/error")
    public String showForm3() {
        return "sampleError";
    }


    @PostMapping("/save")
    public String redirectThankYou(RedirectAttributes redirectAttr, @ModelAttribute("employee") EmployeeDTO employee){

        System.out.println("employee name " + employee.getFirstName());

        Employee employeeEntity = modelMapper.map(employee, Employee.class);

        employee.setId(employeeEntity.getId());
        redirectAttr.addFlashAttribute("employee",
                employee);

        return "redirect:welcome";
    }

    @GetMapping("/welcome")
    public String showWelcome(@ModelAttribute("employee") EmployeeDTO employee, Model model){
        System.out.println("phone " + employee.getPhoneNumber());
        model.addAttribute("name", employee.getFirstName()+" "+employee.getLastName());
        model.addAttribute("address", employee.getAddress() + " " + employee.getPhoneNumber());
        model.addAttribute("id", employee.getId());
        return "welcome";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "registerForm";
    }

}
