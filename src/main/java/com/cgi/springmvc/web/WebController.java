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

    @GetMapping("/newCustomer")
    public String showForm4() {return "newCustomer"; }
    @PostMapping("/save")
    public String redirectThankYou(RedirectAttributes redirectAttr, @ModelAttribute("customer") EmployeeDTO customer){

        System.out.println("customer name " + customer.getFirstName());

        Employee employeeEntity = modelMapper.map(customer, Employee.class);
        employeeEntity = employeeRep.save(employeeEntity);

        customer.setId(employeeEntity.getCustomer_id());
        redirectAttr.addFlashAttribute("customer",
                customer);

        return "redirect:welcome";
    }

    @GetMapping("/welcome")
    public String showWelcome(@ModelAttribute("customer") EmployeeDTO customer, Model model){
        System.out.println("phone " + customer.getPhoneNumber());
        model.addAttribute("name", customer.getFirstName()+" "+customer.getLastName());
        model.addAttribute("address", customer.getAddress() + " " + customer.getPhoneNumber());
        model.addAttribute("id", customer.getId());
        return "welcome";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "registerForm";
    }

}
