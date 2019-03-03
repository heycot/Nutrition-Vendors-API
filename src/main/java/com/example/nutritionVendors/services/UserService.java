package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;

public interface UserService {

    public User findOneByNameAndPassword(User user);
}
