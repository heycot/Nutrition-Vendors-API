package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.services.ShopItemService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ShopItemController.BASE_URL)
public class ShopItemController {
    public final static String BASE_URL = "/api/shop-item";

    @Autowired
    private ShopItemService shopItemService;

    @RequestMapping("/high-rating")
    public ResponseEntity getHighRating() throws InternalError {
        try{
            List<ShopItem> shopItemDTOS = shopItemService.getHighRatingShopItem(10, 0);

            return ResponseEntity.ok(shopItemDTOS);
        } catch (InternalError | NullPointerException e){
            throw new InternalException("Internal Server Error");
        }
    }

    @RequestMapping("/high-rating-item")
    public ResponseEntity getHighRatingItem() throws InternalError {
        try{
            List<ShopItemDTO> shopItemDTOS = shopItemService.getHighRatingItem(10, 0);

            return ResponseEntity.ok(shopItemDTOS);
        } catch (InternalError | NullPointerException e){
            throw new InternalException("Internal Server Error");
        }
    }

    @RequestMapping("/{id}")
    public ResponseEntity getOne(@PathVariable(value = "id") Integer id) throws InternalError {
        try {
            return ResponseEntity.ok(shopItemService.getOne(id));
        } catch (Exception e) {
            throw new InternalError("Internal Server Error");
        }
    }

}
