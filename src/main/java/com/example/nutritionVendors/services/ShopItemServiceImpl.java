package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.respositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopItemServiceImpl implements ShopItemService {
    @Autowired
    private ShopItemRepository shopItemRepository;

    @Override
    public List<ShopItem> getHighRatingItem(Integer start) {
        return shopItemRepository.getHighRatingItem(start);
    }

    @Override
    public ShopItem getOne(Integer id) {
        return shopItemRepository.findOne(id);
    }
}
