package com.project.merokachya.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "aptitudeController")
public class AptitudeController {

    @GetMapping("/aptitude")
    public String displayQuestions(ModelMap modelMap){
        return "home.aptitude";
    }

}
