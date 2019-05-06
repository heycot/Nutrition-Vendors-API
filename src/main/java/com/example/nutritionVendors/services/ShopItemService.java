package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;

import java.util.List;

public interface ShopItemService {
    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset, Integer userId);

//    List<ShopItem> getHighRatingShopItem(Integer limit, Integer offset, Integer userId);

    ShopItem getOne(Integer id);

    List<ShopItemDTO> getAllByShopId(Integer id, Integer offset, Integer limit);

    List<ShopItemDTO> getAll();

    ShopItemDTO getOneHighRatingItem(Integer id);

//    List<ShopItemDTO> searchItem(String searchText, Integer userId);

    List<ShopItemDTO> findAllByUserLoved(Integer userId, Integer offset, Integer limit);

    List<ShopItemDTO> findAllByCategory(Integer categoryId, Integer userId, Integer offset);

    List<ShopItem> findAllByShopIdHadComment(Integer shop_id, Integer id);

    Double getRatingByShopItemId(Integer id);

    ShopItemDTO getOneDTO(Integer id);
}
