package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.services.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(ShopItemController.BASE_URL)
public class ShopItemController {
    public final static String BASE_URL = "/api/shop-item";

    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private RecentSearchService recentSearchService;


    @GetMapping("/search/{searchText}")
    public ResponseEntity searchItem(@PathVariable(name = "searchText") String searchText) throws InternalError {
        try{
            String result = java.net.URLDecoder.decode(searchText, StandardCharsets.UTF_8.name());

            return ResponseEntity.ok(searchService.searchItem(result));

        } catch (Exception e ){
            System.out.println(e.getCause());
            throw new InternalException("Internal Server Error");
        }
    }

    @RequestMapping("/high-rating/offset/{off}")
    public ResponseEntity getHighRatingItem(@PathVariable(name = "off") Integer offset) throws InternalError {
        try{

                return ResponseEntity.ok(shopItemService.getHighRatingItem(offset));

        } catch (Exception e){
            System.out.println(e.getCause());
            throw new InternalException("Internal Server Error");
        }
    }


    @RequestMapping("/{id}/{isSearch}")
    public ResponseEntity getOne(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(value = "id") Integer id, @PathVariable(value = "isSearch") Integer isSearch) throws InternalError {
        try {
            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(shopItemService.getOne(id));

            } else {


                User user = userService.findByToken(authorizationHeader);

                ShopItem shopItem = shopItemService.getOne(id);

                //if (shopItem != null && isSearch == 1 && user != null) {

                    //recentSearchService.updateOneByEntityId(id, 0, user);
               // }
                return ResponseEntity.ok(shopItem);
            }
        } catch (Exception e) {
            throw new InternalError("Internal Server Error");
        }
    }


    @GetMapping("/dto/{id}")
    public ResponseEntity getOneDTO(@PathVariable(value = "id") Integer id) throws InternalError {
        try {
            return ResponseEntity.ok(shopItemService.getOneDTO(id));
        } catch (Exception e) {
            throw new InternalError("Internal Server Error");
        }
    }

    @GetMapping("/shop/{id}/{offset}")
    public ResponseEntity getAllByShopId( @PathVariable(name = "id") Integer id, @PathVariable(name = "offset") Integer offset){
        try {

            return ResponseEntity.ok(shopItemService.getAllByShopId(id, offset, Contants.LIMIT));

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(shopItemService.getAll());
    }


    @GetMapping("/love/{offset}")
    public ResponseEntity findAllByUserLoved(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "offset") Integer offset) throws InternalError {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return new ResponseEntity<>("Authorization token is wrong", HttpStatus.NOT_FOUND);

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(shopItemService.findAllByUserLoved(user.getId(), offset, Contants.LIMIT));
            }

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category/{id}/{off}")
    public ResponseEntity findAllByCategory(@PathVariable(name = "id") Integer id, @PathVariable(name = "off") Integer offset) throws InternalError {

        try {

                return ResponseEntity.ok(shopItemService.findAllByCategory(id, offset));

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity getRating(@PathVariable(name = "id") Integer id) throws InternalError {

        try {

            return ResponseEntity.ok(shopItemService.getRatingByShopItemId(id));

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
