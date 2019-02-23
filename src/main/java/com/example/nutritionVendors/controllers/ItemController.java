package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ItemController.BASE_URL)
public class ItemController {
    public final static String BASE_URL = "api/item";
}
