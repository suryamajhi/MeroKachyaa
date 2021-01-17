package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Comment;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.CommentRepository;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller(value="userCommentController")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/blog/{blogId}/comment")
    public String add(@PathVariable int blogId, @RequestParam String content){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setBlogId(blogId);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        comment.setUserId(user.getId());
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        comment.setDate(date);
        commentRepository.save(comment);
        return "redirect:/blog/"+blogId;
    }
}
