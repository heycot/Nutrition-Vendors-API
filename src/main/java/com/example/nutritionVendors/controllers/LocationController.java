package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LocationController.BASE_URL)
public class LocationController {
    public final static String BASE_URL ="/api/location";
}
