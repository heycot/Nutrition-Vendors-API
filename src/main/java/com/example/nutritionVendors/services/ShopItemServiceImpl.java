package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.respositories.DTOShopItemRepository;
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
    private DTOShopItemRepository dtoShopItemRepository;


    @Override
    public List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset) {
        return dtoShopItemRepository.getHighRatingItem(limit, offset);
    }

    @Override
    public List<ShopItem> getHighRatingShopItem(Integer limit, Integer offset) {
        return shopItemRepository.findHighRatingItem(limit, offset);
    }

    @Override
    public ShopItem getOne(Integer id) {
        return shopItemRepository.findOneById(id);
    }

    @Override
    public List<ShopItemDTO> getAllByShopId(Integer id, Integer limit, Integer offset) {

        return dtoShopItemRepository.getAllByShopId(id, limit, offset);
    }

    @Override
    public ShopItemDTO getOneHighRatingItem(Integer id) {
        return dtoShopItemRepository.getOneById(id);
    }

    @Override
    public List<ShopItemDTO> searchItema(String searchText) {
        return dtoShopItemRepository.searchItem(searchText);
    }
}
