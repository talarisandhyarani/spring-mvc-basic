package com.cgi.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;

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

}
