package com.project.merokachya.services;

import com.project.merokachya.dto.BlogRequest;

public interface BlogService {
    public void addBlog(BlogRequest blogRequest);

    public void editBlog(int id, BlogRequest blogRequest);
}
