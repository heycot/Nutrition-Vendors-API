package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.Item;
import com.example.nutritionVendors.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ItemController.BASE_URL)
public class ItemController {
    public final static String BASE_URL = "api/item";

    @Autowired
    private ItemService itemService;

    @RequestMapping
    public String hello() {
        return "hello spring";
    }

    @GetMapping
    public ResponseEntity getAll() {
       return ResponseEntity.ok(itemService.getall());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

}
