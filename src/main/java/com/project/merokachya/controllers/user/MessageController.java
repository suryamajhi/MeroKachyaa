package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Message;
import com.project.merokachya.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;

@Controller(value = "userMessageController")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @PostMapping("/message")
    public String message(@ModelAttribute Message message){
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        message.setDate(date);
        messageRepository.save(message);
        return "home.index";
    }
}
