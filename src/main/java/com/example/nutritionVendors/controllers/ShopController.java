package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ShopController.BASE_URL)
public class ShopController {
    public final static String BASE_URL = "/api/shop";

    @Autowired
    private ShopService shopService;

    @GetMapping("/{offset}")
    public ResponseEntity findAllShop(@PathVariable Integer offset) {
        try {
            return ResponseEntity.ok(shopService.findAllShop(10, offset));
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
}
