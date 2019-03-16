package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public final static String BASE_URL = "/api/user";

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity login(@Valid @RequestBody User user) {
       User user1 = userService.findOneByNameAndPassword(user);

       return ResponseEntity.ok(user1);
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
