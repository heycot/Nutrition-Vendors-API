package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;

import java.util.List;

public interface ShopItemService {
    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset);

    List<ShopItem> getHighRatingShopItem(Integer limit, Integer offset);

    ShopItem getOne(Integer id);
}
