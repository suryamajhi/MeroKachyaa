package com.project.merokachya.services;

import com.project.merokachya.dto.ProfileRequest;
import org.springframework.stereotype.Service;


public interface ProfileService {
    public void editProfile(int id, ProfileRequest profileRequest);
}
