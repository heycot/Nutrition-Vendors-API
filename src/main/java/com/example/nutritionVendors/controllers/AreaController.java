package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.Area;
import com.example.nutritionVendors.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {
    public final static String BASE_URL = "/api/area";

    @Autowired
    private AreaService areaService;

    @RequestMapping()
    public List<Area> getAll() {
        return areaService.getAll();
    }
}
