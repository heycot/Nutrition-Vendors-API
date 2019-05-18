package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.respositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DocumentController.BASE_URL)
public class DocumentController {
    public final static String BASE_URL = "/api/document";

    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(documentRepository.findAllByShopItemId(id));
    }
}
