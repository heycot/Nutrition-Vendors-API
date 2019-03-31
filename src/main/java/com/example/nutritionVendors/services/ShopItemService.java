package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShopItemService {
    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset);

    List<ShopItem> getHighRatingShopItem(Integer limit, Integer offset);

    ShopItem getOne(Integer id);

    List<ShopItemDTO> getAllByShopId(Integer id, Integer limit, Integer offset);

    List<ShopItemDTO> getAll();

    ShopItemDTO getOneHighRatingItem(Integer id);

    List<ShopItemDTO> searchItem(String searchText);
}
