package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.respositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<Shop> findAllShop(Integer limit, Integer offset) {
        return shopRepository.findOrOrderByRating(limit, offset);
    }
}
