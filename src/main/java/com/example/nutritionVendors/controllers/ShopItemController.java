package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.services.ShopItemService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ShopItemController.BASE_URL)
public class ShopItemController {
    public final static String BASE_URL = "/api/shop-item";

    @Autowired
    private ShopItemService shopItemService;

    @RequestMapping("/high-rating")
    public ResponseEntity getHighRatingItem() throws InternalError {
        try{
            List<ShopItem> shopItemDTOS = shopItemService.getHighRatingShopItem(10);

            return ResponseEntity.ok(shopItemDTOS);
        } catch (InternalError | NullPointerException e){
            throw new InternalException("Internal Server Error");
        }
    }

    @RequestMapping("/{id}")
    public ShopItem getOne(@RequestParam("id") Integer id) {
        return shopItemService.getOne(id);
    }

}
