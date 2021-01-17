package com.project.merokachya.controllers.admin;

import com.project.merokachya.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminMessageController")
@RequestMapping("/admin")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/messages")
    public String inbox(ModelMap modelMap){
        modelMap.addAttribute("messages", messageRepository.findAll());
        return "admin.message.index";

    }
    @GetMapping("/message/compose")
    public String compose(){
        return "admin.message.compose";
    }

    @GetMapping("/message/{id}")
    public String read(@PathVariable int id, ModelMap modelMap){
        modelMap.addAttribute("message", messageRepository.findById(id).get());
        return "admin.message.read";
    }

}
