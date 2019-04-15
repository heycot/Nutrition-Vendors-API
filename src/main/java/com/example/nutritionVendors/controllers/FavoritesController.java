package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.FavoritesService;
import com.example.nutritionVendors.services.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FavoritesController.BASE_URL)
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


    @GetMapping("/check/{shopitem_id}")
    public ResponseEntity getLoveStatus(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "shopitem_id") Integer shopitem_id) throws InternalError {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(new Favorites());

            } else {
                User user = userService.findByToken(authorizationHeader);
                Favorites favorites = favoritesService.getLoveStatus(shopitem_id, user);
                if (favorites == null ) {
                    return ResponseEntity.ok(new Favorites());
                } else {
                    return ResponseEntity.ok(favorites);
                }
            }

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/love/{id}")
    public ResponseEntity loveOneitem(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(value = "id") Integer shopItemId) throws InternalError {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return new ResponseEntity<>("Authorization token is wrong", HttpStatus.NOT_FOUND);

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(favoritesService.loveOne(shopItemId, user.getId()));
            }

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/count/{id}")
    public ResponseEntity countNumberComment(@PathVariable(name = "id") Integer shopitem_id) throws InternalError {
        try {

            return ResponseEntity.ok(commentService.countNumberCommentByShopItem(shopitem_id));

        } catch (Exception e) {
            System.out.println(e.getCause());
            throw  new InternalException("internal exception error");
        }

    }

}
