package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public final static String BASE_URL = "/api/user";

    @Autowired
    private UserService userService;

    @GetMapping
    public String login(@Valid @RequestBody User user) {
        if (userService.findOneByNameAndPassword(user) != null ) {
            return "";
        }

        return null;
    }

}
