package com.project.merokachya.services;

import com.project.merokachya.dto.CategoryRequest;


public interface CategoryService {
    public void addCategory(CategoryRequest category);
    public void editCategory(int id, CategoryRequest category);
}
