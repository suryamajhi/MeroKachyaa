package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Discussion;
import com.project.merokachya.entities.DiscussionReply;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.DiscussionReplyRepository;
import com.project.merokachya.repos.DiscussionRepository;
import com.project.merokachya.repos.LessonRepository;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Calendar;

@Controller(value = "userDiscussionController")
public class DiscussionController {

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    DiscussionReplyRepository discussionReplyRepository;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/lesson/{lessonId}/discussion")
    public String add(@PathVariable int lessonId, @RequestParam String content) {
        Discussion discussion = new Discussion();
        discussion.setContent(content);
        discussion.setLessonId(lessonId);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        discussion.setDate(date);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        discussion.setUserId(user.getId());

        discussionRepository.save(discussion);


        int courseId = lessonRepository.findById(lessonId).get().getChapterByChapterId().getCourseId();

        return "redirect:/course/" + courseId + "/detail";
    }


//    Also for discussion Reply

    @PostMapping("/discussion/{id}/reply")
    public String addReply(@PathVariable int id, @RequestParam String content) {
        DiscussionReply reply = new DiscussionReply();
        reply.setContent(content);
        reply.setDiscussionId(id);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        reply.setUserId(user.getId());
        reply.setDate(new Date(Calendar.getInstance().getTime().getTime()));

        discussionReplyRepository.save(reply);

        int courseId = discussionRepository.findById(id).get().getLessonByLessonId().getChapterByChapterId().getCourseId();

        return "redirect:/course/" + courseId + "/detail";
    }
}
