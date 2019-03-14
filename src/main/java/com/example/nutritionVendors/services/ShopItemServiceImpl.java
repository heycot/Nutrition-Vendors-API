package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.respositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopItemServiceImpl implements ShopItemService {
    @Autowired
    private ShopItemRepository shopItemRepository;


    @Override
    public List<ShopItemDTO> getHighRatingItem(Integer start) {

        List<ShopItemDTO> shopItemDTOS = new ArrayList<>();

        shopItemDTOS = shopItemRepository.getHighRatingItem(start);

        return shopItemDTOS;
    }

    @Override
    public List<ShopItem> getHighRatingShopItem(Integer start) {
        return shopItemRepository.findHighRatingItem(start);
    }

    @Override
    public ShopItem getOne(Integer id) {
        return shopItemRepository.findOne(id);
    }
}
