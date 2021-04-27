package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Comment;
import com.project.merokachya.entities.CommentReply;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.CommentReplyRepository;
import com.project.merokachya.repos.CommentRepository;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller(value = "userCommentReplyController")
public class CommentReplyController {

    @Autowired
    CommentReplyRepository commentReplyRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/comment/{commentId}/reply")
    public String reply(@PathVariable int commentId, @RequestParam String content) {
        Comment comment = commentRepository.findById(commentId).get();
        CommentReply reply = new CommentReply();
        reply.setCommentId(commentId);
        reply.setContent(content);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        reply.setDate(date);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        reply.setUserId(user.getId());
        commentReplyRepository.save(reply);
        return "redirect:/blog/" + comment.getBlogId();
    }

}
