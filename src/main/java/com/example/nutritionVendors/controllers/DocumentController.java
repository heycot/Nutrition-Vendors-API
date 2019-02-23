package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DocumentController.BASE_URL)
public class DocumentController {
    public final static String BASE_URL = "/api/document";
}
