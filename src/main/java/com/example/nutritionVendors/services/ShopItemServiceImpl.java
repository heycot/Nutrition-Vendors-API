package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.respositories.DTOSopItemRepository;
import com.example.nutritionVendors.respositories.DocumentRepository;
import com.example.nutritionVendors.respositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopItemServiceImpl implements ShopItemService {
    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DTOSopItemRepository dtoSopItemRepository;


    @Override
    public List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset) {

        List<ShopItemDTO> shopItemDTOS = new ArrayList<>();

        shopItemDTOS = dtoSopItemRepository.getHighRatingItem(limit, offset);
//        for (ShopItemDTO item: shopItemDTOS) {
//            Document documents = documentRepository.getFirstByShopItem_Id(item.getId());
//            item.setAvatar(documents.getLink());
//        }

        return shopItemDTOS;
    }

    @Override
    public List<ShopItem> getHighRatingShopItem(Integer limit, Integer offset) {
        return shopItemRepository.findHighRatingItem(limit, offset);
    }

    @Override
    public ShopItem getOne(Integer id) {
        return shopItemRepository.findOneById(id);
    }
}
