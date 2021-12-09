package com.project.salsa_Modas_Manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Html {

    @GetMapping("/home")
    public String home(){
        return "/page";
    }
}
