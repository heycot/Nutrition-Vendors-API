package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;

import java.util.List;

public interface UserService {

    User findOneByNameAndPassword(String username, String password);

    User findOneById(Integer id);

    List<User> findAll();

    User signUp(User user);

    User getOneById(Integer id);
}
