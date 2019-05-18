package com.example.nutritionVendors.services;


import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.entities.Item;

import java.util.List;

public interface ItemService {
    List<Item> getall();

    List<Item> getById(Integer id);
}
