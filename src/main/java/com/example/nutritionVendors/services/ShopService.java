package com.example.nutritionVendors.services;


import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.entities.ShopItem;

import java.util.List;

public interface ShopService {
    List<Shop> findAllShop( Integer offset);

    Shop findOneById(Integer id);

    List<Shop>  findNearestByUserLocation(Double latitude, Double longitude, Integer offset);

    List<Shop> findAllNewest(Integer offset);

//    Shop findOneByShopItemId(Integer id);


    Shop findOneByShopItemId(List<ShopItem> shopItems);

    void updateStatusWhenCommented(ShopItem shopItem);

    List<Shop> findAllByAuthor(Integer id);
}
