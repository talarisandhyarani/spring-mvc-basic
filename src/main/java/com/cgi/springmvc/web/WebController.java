package com.cgi.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.cgi.springmvc.beans.Customer;

@Controller
public class WebController {

    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }
    
    @GetMapping("/sample2")
    public String showForm2() {
        return "sample2";
    }

    @GetMapping("/newCustomer")
    public String showForm4(){
        return "newCustomer";
    }

    @PostMapping("/redirectView")
    public RedirectView redirectView(RedirectAttributes attributes,@ModelAttribute("customer") Customer customer) {
        attributes.addFlashAttribute("customer", customer);
        return new RedirectView("/thankyou");
    }
 

    @GetMapping("/thankyou")
    public String showForm5(@ModelAttribute("customer") Customer customer, Model model){
        model.addAttribute("name", customer.getFirstName() + " " + customer.getLastName());
        model.addAttribute("mailingAddress", customer.getStreetAddress() + ", " + customer.getCity() + ", " + customer.getStateAbbr() + " " + customer.getZipCode());
        model.addAttribute("phoneNumber", customer.getPhoneNumber());
        return "thankyou";
    }

    @GetMapping("/customerTest")
    public String showForm6(Model model){
        String url = "http://localhost:8080/api/v1/getCustomer/?cid=1";

        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(url, Customer.class);

        model.addAttribute("name", customer.getFirstName() + " " + customer.getLastName());

        return "customerTest";

    }
}
