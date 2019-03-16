package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public final static String BASE_URL = "/api/user";

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody User user) {

        try {
            User user1 = userService.findOneByNameAndPassword(user.getUser_name(), user.getPassword());
//
            return ResponseEntity.ok(user1);
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody User user) {

        try {
            User user1 = userService.signUp(user);

            return ResponseEntity.ok(user1);
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception with sign up", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity getOne(@PathVariable(name = "id") Integer id){
        User user = userService.findOneById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public  ResponseEntity getAll(){
        List<User> user = userService.findAll();

        return ResponseEntity.ok(user);
    }
}
