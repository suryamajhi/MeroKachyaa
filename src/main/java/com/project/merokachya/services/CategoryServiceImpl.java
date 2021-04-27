package com.project.merokachya.services;

import com.project.merokachya.dto.CategoryRequest;
import com.project.merokachya.entities.Category;
import com.project.merokachya.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.aspectj.util.LangUtil.isEmpty;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        System.out.println(category);
        MultipartFile image = categoryRequest.getImage();

        if (image != null && !isEmpty(image.getOriginalFilename())) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());

            try {
                if (fileName.contains("..")) {
                    throw new IOException("Sorry!Filename contains invalid path sequence");
                }
                category.setImage(image.getBytes());
                categoryRepository.save(category);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            categoryRepository.save(category);
        }
    }

    @Override
    public void editCategory(int id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).get();
        category.setName(categoryRequest.getName());
        MultipartFile image = categoryRequest.getImage();

        if (image != null && !isEmpty(image.getOriginalFilename())) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());

            try {
                if (fileName.contains("..")) {
                    throw new IOException("Sorry!Filename contains invalid path sequence");
                }
                category.setImage(image.getBytes());
                categoryRepository.save(category);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }
}
