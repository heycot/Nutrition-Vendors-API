package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import org.springframework.http.ResponseEntity;
import sun.jvm.hotspot.utilities.IntegerEnum;

import java.util.List;

public interface ShopItemService {
    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset, Integer userId);

//    List<ShopItem> getHighRatingShopItem(Integer limit, Integer offset, Integer userId);

    ShopItem getOne(Integer id);

    List<ShopItemDTO> getAllByShopId(Integer id, Integer limit, Integer offset, Integer userId);

    List<ShopItemDTO> getAll();

    ShopItemDTO getOneHighRatingItem(Integer id);

    List<ShopItemDTO> searchItem(String searchText, Integer userId);
}
