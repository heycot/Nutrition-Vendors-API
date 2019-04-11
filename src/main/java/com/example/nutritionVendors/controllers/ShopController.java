package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping(ShopController.BASE_URL)
public class ShopController {
    public final static String BASE_URL = "/api/shop";

    @Autowired
    private ShopService shopService;

    @GetMapping("/{offset}")
    public ResponseEntity findAllShop(@PathVariable Integer offset) {
        try {
            return ResponseEntity.ok(shopService.findAllShop(offset, Contants.LIMIT));
        } catch (Exception e) {
            System.out.println("exception: " + e.getCause());

            return new ResponseEntity<>("internal exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findOneById(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(shopService.findOneById(id));
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
