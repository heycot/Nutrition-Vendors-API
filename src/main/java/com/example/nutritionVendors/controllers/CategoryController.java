package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.services.CategoryService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {
    public final static String BASE_URL = "/api/category";

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity findAll() throws InternalError {
        try {
            return ResponseEntity.ok(categoryService.findAll());
        } catch (Exception e) {
            System.out.println("internal error: " + e.getCause());
            throw  new InternalException("internal exception error");
        }
    }
}
