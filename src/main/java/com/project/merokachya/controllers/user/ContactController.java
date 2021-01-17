package com.project.merokachya.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "userContactController")
public class ContactController {

    @GetMapping("/contact")
    public String show(){
        return "home.contact";
    }
}
