package com.project.merokachya.services;

import com.project.merokachya.dto.ProfileRequest;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

import static org.aspectj.util.LangUtil.isEmpty;


@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void editProfile(int id, ProfileRequest profileRequest) {
        User user = userRepository.findById(id).get();
        System.out.println(user);
        user.setName(profileRequest.getName());
        user.setEmail(profileRequest.getEmail());
        user.setAddress(profileRequest.getAddress());
        user.setSchool(profileRequest.getSchool());
        user.setSignature(profileRequest.getSignature());

        MultipartFile image = profileRequest.getImage();

        if(image!=null && !isEmpty(image.getOriginalFilename())){
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));
            System.out.println("IM in");
            try{
                if(fileName.contains("..")){
                    throw new IOException("Invalid filename");
                }
                user.setImage(image.getBytes());
                userRepository.save(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else userRepository.save(user);
    }
}
