package com.project.merokachya.services;

import com.project.merokachya.dto.BlogRequest;
import com.project.merokachya.entities.Blog;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.BlogRepository;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Calendar;

import static org.aspectj.util.LangUtil.isEmpty;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addBlog(BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setTitle(blogRequest.getTitle());
        blog.setContent(blogRequest.getContent());
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        blog.setDate(date);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        blog.setUserId(user.getId());

        MultipartFile image = blogRequest.getImage();

        if (image != null && !isEmpty(image.getOriginalFilename())) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());

            try {
                if (fileName.contains("..")) {
                    throw new IOException("Sorry!Filename contains invalid path sequence");
                }
                blog.setImage(image.getBytes());
                blogRepository.save(blog);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            blogRepository.save(blog);
        }
    }

    @Override
    public void editBlog(int id, BlogRequest blogRequest) {
        Blog blog = blogRepository.findById(id).get();
        blog.setTitle(blogRequest.getTitle());
        blog.setContent(blogRequest.getContent());

        MultipartFile image = blogRequest.getImage();

        if (image != null && !isEmpty(image.getOriginalFilename())) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());

            try {
                if (fileName.contains("..")) {
                    throw new IOException("Sorry!Filename contains invalid path sequence");
                }
                blog.setImage(image.getBytes());
                blogRepository.save(blog);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            blogRepository.save(blog);
        }
    }
}
