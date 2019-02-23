package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CityController.BASE_URL)
public class CityController {
    public final static String BASE_URL = "api/city";
}
