package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {
    public final static String BASE_URL = "/api/area";
}
