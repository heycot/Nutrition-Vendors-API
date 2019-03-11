package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.services.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ShopItemController.BASE_URL)
public class ShopItemController {
    public final static String BASE_URL = "/api/shop-item";

    @Autowired
    private ShopItemService shopItemService;

    @RequestMapping("/high-rating")
    public List<ShopItem> getHighRatingItem() {
        List<ShopItem> shopItems = shopItemService.getHighRatingItem(0);

        return shopItems;
    }

}
