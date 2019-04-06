package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    User findOneByEmailAndPassword(String email, String password);

    User findOneById(Integer id);

    List<User> findAll();

    User signUp(User user);

    User getOneById(Integer id);

    User findByToken(String authorizationHeader);

    void saveImage(User user, MultipartFile file);
}
