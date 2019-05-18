package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.respositories.ShopRepository;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopItemService shopItemService;

    @Override
    public List<Shop> findAllShop( Integer offset) {
//        return shopRepository.findOrOrderByRating( offset, Contants.LIMIT);
        return shopRepository.findAll();
    }

    @Override
    public Shop findOneById(Integer id) {
        return shopRepository.findOne(id);
    }

    @Override
    public List<Shop> findNearestByUserLocation(Double latitude, Double longitude, Integer offset) {
        return shopRepository.findNearestUserLocation(latitude, longitude, offset, Contants.LIMIT);
    }

    @Override
    public List<Shop> findAllNewest(Integer offset) {
        return shopRepository.findNewest(offset, Contants.LIMIT);
    }

//    @Override
//    public Shop findOneByShopItemId(Integer id) {
//        return shopRepository.findOneByShopItemId(id);
//    }


    @Override
    public Shop findOneByShopItemId(List<ShopItem> shopItems) {
        return shopRepository.findByShopItems(shopItems);
    }

    @Override
    public void updateStatusWhenCommented(ShopItem shopItem) {
        Integer shopid = shopRepository.findIdByShopItemId(shopItem.getId());

        Shop shop = shopRepository.findOne(shopid);
        List<ShopItem> shopItemList = shopItemService.findAllByShopIdHadComment(shop.getId(), shopItem.getId());
        shop.setRating(shop.getRating() * shopItemList.size() + shopItem.getRating()/ (shopItemList.size() + 1));

        shopRepository.save(shop);

    }

    @Override
    public List<Shop> findAllByAuthor(Integer id) {
        return shopRepository.findAllByUserId(id);
    }
}
