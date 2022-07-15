package com.cgi.springmvc.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class WebController {

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

    @GetMapping("/register")
    public String showRegisterForm() {
        return "registerForm";
    }

    @RequestMapping("/welcome")
    public String displayRegister(HttpServletRequest request, Model regModel) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("emailAddress");

        regModel.addAttribute(firstName);
        regModel.addAttribute(lastName);
        regModel.addAttribute(phone);
        regModel.addAttribute(email);

        String welcomeMessage = "Hello, " + firstName + " " + lastName + ".\n Your email is: " + email + ".\n Your phone number is: " + phone + ".";
        regModel.addAttribute("welcomeMessage", welcomeMessage);

        return "welcome";
    }



}
