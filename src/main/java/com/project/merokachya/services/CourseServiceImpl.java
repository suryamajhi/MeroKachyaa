package com.project.merokachya.services;

import com.project.merokachya.dto.CourseRequest;
import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.CourseRepository;
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
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        System.out.println(courseRequest);
        Course course = new Course();
        course.setName(courseRequest.getName());
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        course.setDate(date);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        course.setUserId(user.getId());
        course.setCategoryId(courseRequest.getCategoryId());

        MultipartFile image = courseRequest.getImage();

        if(image != null && !isEmpty(image.getOriginalFilename())){
            String fileName  = StringUtils.cleanPath(image.getOriginalFilename());

            try{
                if(fileName.contains("..")){
                    throw new IOException("Sorry!Filename contains invalid path sequence");
                }
                course.setImage(image.getBytes());
                courseRepository.save(course);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }else{
            courseRepository.save(course);
        }
        return courseRepository.findByName(course.getName());
    }

    @Override
    public Course editCourse(int id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).get();

        course.setName(courseRequest.getName());
        course.setCategoryId(courseRequest.getCategoryId());

        MultipartFile image = courseRequest.getImage();

        if(image != null && !isEmpty(image.getOriginalFilename())){
            String fileName  = StringUtils.cleanPath(image.getOriginalFilename());

            try{
                if(fileName.contains("..")){
                    throw new IOException("Sorry!Filename contains invalid path sequence");
                }
                course.setImage(image.getBytes());
                courseRepository.save(course);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }else{
            courseRepository.save(course);
        }
        return courseRepository.findById(id).get();
    }
}
