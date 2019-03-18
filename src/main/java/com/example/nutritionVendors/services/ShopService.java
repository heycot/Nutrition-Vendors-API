package com.example.nutritionVendors.services;


import com.example.nutritionVendors.entities.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> findAllShop(Integer limit, Integer offset);

    Shop findOneById(Integer id);
}
