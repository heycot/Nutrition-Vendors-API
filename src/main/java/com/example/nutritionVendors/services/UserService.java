package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;

import java.util.List;

public interface UserService {

    User findOneByNameAndPassword(User user);

    User findOneById(Integer id);

    List<User> findAll();
}
