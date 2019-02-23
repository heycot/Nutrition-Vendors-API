package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.Shop;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ShopController.BASE_URL)
public class ShopController {
    public final static String BASE_URL = "/api/shop";
}
