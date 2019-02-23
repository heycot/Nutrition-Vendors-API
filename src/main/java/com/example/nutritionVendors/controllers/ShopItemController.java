package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ShopItemController.BASE_URL)
public class ShopItemController {
    public final static String BASE_URL = "/api/shop-item";
}
