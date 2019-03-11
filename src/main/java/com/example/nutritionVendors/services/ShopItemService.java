package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.ShopItem;

import java.util.List;

public interface ShopItemService {
    List<ShopItem> getHighRatingItem(Integer start);
}
