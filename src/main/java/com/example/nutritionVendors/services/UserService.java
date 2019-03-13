package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;

public interface UserService {

    User findOneByNameAndPassword(User user);
}
