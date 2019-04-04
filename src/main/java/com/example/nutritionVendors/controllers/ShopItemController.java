package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.FavoritesService;
import com.example.nutritionVendors.services.ShopItemService;
import com.example.nutritionVendors.services.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ShopItemController.BASE_URL)
public class ShopItemController {
    public final static String BASE_URL = "/api/shop-item";

    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private FavoritesService favoritesService;

//    @RequestMapping("/high-rating")
//    public ResponseEntity getHighRating() throws InternalError {
//        try{
//            List<ShopItem> shopItemDTOS = shopItemService.getHighRatingShopItem(10, 0);
//
//            return ResponseEntity.ok(shopItemDTOS);
//        } catch (InternalError | NullPointerException e){
//            throw new InternalException("Internal Server Error");
//        }
//    }

    @GetMapping("/search/{searchText}")
    public ResponseEntity searchItem(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "searchText") String searchText) throws InternalError {
        try{

            if (authorizationHeader == null || authorizationHeader == "" || authorizationHeader == "guest") {
                return  ResponseEntity.ok(shopItemService.searchItem(searchText, 0));

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(shopItemService.searchItem(searchText, user.getId()));
            }


        } catch (InternalError | NullPointerException e){
            System.out.println(e.getCause());
            throw new InternalException("Internal Server Error");
        }
    }

    @RequestMapping("/high-rating/offset/{off}")
    public ResponseEntity getHighRatingItem(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "off") Integer offset) throws InternalError {
        try{

            if (authorizationHeader == null || authorizationHeader == "" || authorizationHeader == "guest") {
                return ResponseEntity.ok(shopItemService.getHighRatingItem(offset, 10, 0));

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(shopItemService.getHighRatingItem(offset, 10, user.getId()));
            }

        } catch (InternalError | NullPointerException e){
            System.out.println(e.getCause());
            throw new InternalException("Internal Server Error");
        }
    }

//    @GetMapping("/high-rating-item/{id}")
//    public ResponseEntity getOneHighRatingItem( @PathVariable(name = "id") Integer id ) throws InternalError {
//        try{
//
//            ShopItemDTO shopItemDTO = shopItemService.getOneHighRatingItem(id);
//
//            return ResponseEntity.ok(shopItemDTO);
//        } catch (InternalError | NullPointerException e){
//            System.out.println(e.getCause());
//            throw new InternalException("Internal Server Error");
//        }
//    }

    @RequestMapping("/{id}")
    public ResponseEntity getOne(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(value = "id") Integer id) throws InternalError {
        try {
            return ResponseEntity.ok(shopItemService.getOne(id));
        } catch (Exception e) {
            throw new InternalError("Internal Server Error");
        }
    }

    @GetMapping("/shop/{id}/{offset}")
    public ResponseEntity getAllByShopId(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "id") Integer id, @PathVariable(name = "offset") Integer offset){
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(shopItemService.getAllByShopId(id, 10, offset, 0));

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(shopItemService.getAllByShopId(id, 10, offset, user.getId()));
            }

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(shopItemService.getAll());
    }


    @GetMapping("/love/{id}/{status}")
    public ResponseEntity loveOneitem(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(value = "id") Integer shopItemId, @PathVariable(value = "status") Integer status) throws InternalError {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return new ResponseEntity<>("Authorization token is wrong", HttpStatus.NOT_FOUND);

            } else {
                User user = userService.findByToken(authorizationHeader);
                return ResponseEntity.ok(favoritesService.loveOne(shopItemId, user.getId(), status));
            }

        } catch (Exception e){
            System.out.println("exception: " + e.getCause());
            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
