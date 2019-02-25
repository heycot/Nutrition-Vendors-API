package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findOneByNameAndPassword(User user);
}
