package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.FavoritesService;
import com.example.nutritionVendors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DocumentController.BASE_URL)
public class FavoritesController {
    public final static String BASE_URL = "/api/favorites";

    @Autowired
    private FavoritesService favoritesService;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity findAllByUserId(@RequestHeader(value = "Authorization") String authorizationHeader) throws InternalError {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return new ResponseEntity<>("Authorization token is wrong", HttpStatus.NOT_FOUND);

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(favoritesService.findAllByuserId(user.getId()));
            }
        } catch (Exception e) {
            System.out.println("internal exception" + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
