package com.example.nutritionVendors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommentController.BASE_URL)
public class CommentController {
    public final static String BASE_URL = "/api/comment";
}
