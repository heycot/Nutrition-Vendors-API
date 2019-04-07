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

    @Override
    public Shop findOneById(Integer id) {
        return shopRepository.findOne(id);
    }

    @Override
    public List<Shop> findNearestByUserLocation(Double latitude, Double longitude, Integer offset) {
        return shopRepository.findNearestUserLocation(latitude, longitude, offset, 10);
    }

    @Override
    public List<Shop> findAllNewest(Integer offset) {
        return shopRepository.findNewest(offset, 10);
    }
}
