package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.RecentSearch;
import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.services.RecentSearchService;
import com.example.nutritionVendors.services.ShopService;
import com.example.nutritionVendors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(ShopController.BASE_URL)
public class ShopController {
    public final static String BASE_URL = "/api/shop";

    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecentSearchService recentSearchService;


    @GetMapping("/offset/{offset}")
    public ResponseEntity findAllShop(@PathVariable Integer offset) {
        try {
            return ResponseEntity.ok(shopService.findAllShop(offset, Contants.LIMIT));
        } catch (Exception e) {
            System.out.println("exception: " + e.getCause());

            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/{isSearch}")
    public ResponseEntity findOneById(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "id") Integer id, @PathVariable(value = "isSearch") Integer isSearch) {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(shopService.findOneById(id));

            } else {
                User user = userService.findByToken(authorizationHeader);
                Shop shop = shopService.findOneById(id);

                if (shop != null && isSearch == 1) {

                    recentSearchService.updateOneByEntityId(id, 1, user);
                }

                return ResponseEntity.ok(shop);
            }

        } catch (Exception e) {
            System.out.println("exception: " + e.getCause());

            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nearest/{lat}/{long}/{offset}")
    public ResponseEntity findNearestByUserLocation(@PathVariable(name = "lat") Double latitude, @PathVariable(name = "long") Double longitude,
                                                    @PathVariable(name = "offset") Integer offset) {
        try {
            return ResponseEntity.ok(shopService.findNearestByUserLocation(latitude, longitude, offset));
        } catch (Exception e) {
            System.out.println("exception: " + e.getCause());

            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/newest/{offset}")
    public ResponseEntity findAllNewest(@PathVariable(name = "offset") Integer offset) {
        try {
            return ResponseEntity.ok(shopService.findAllNewest(offset));
        } catch (Exception e) {
            System.out.println("exception: " + e.getCause());

            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
