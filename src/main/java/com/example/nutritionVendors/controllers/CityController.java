package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.City;
import com.example.nutritionVendors.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CityController.BASE_URL)
public class CityController {
    public final static String BASE_URL = "api/city";

    @Autowired
    private CityService cityService;

    @RequestMapping
    public List<City> findAll() {
        return cityService.findAll();
    }
}
