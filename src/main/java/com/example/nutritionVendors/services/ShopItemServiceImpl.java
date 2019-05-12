package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.respositories.*;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
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

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private DTOFavoritesRepository dtoFavoritesRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public ShopItem getOne(Integer id) {
        return shopItemRepository.findOneById(id);
    }


    @Override
    public List<ShopItemDTO> getAll() {
        return dtoShopItemRepository.getAll();
    }

    @Override
    public ShopItemDTO getOneHighRatingItem(Integer id) {
        return dtoShopItemRepository.getOneById(id);
    }


    @Override
    public List<ShopItemDTO> findAllByUserLoved(Integer userId, Integer offset, Integer limit) {
        List<FavoritesDTO> favoritesDTOS = dtoFavoritesRepository.findAllByUser_idAndStatus(userId, 1, offset, limit);
        List<ShopItemDTO> shopItemDTOS = new ArrayList<>();
        ShopItemDTO item;

        for (int i = 0; i < favoritesDTOS.size(); i++) {
            item = dtoShopItemRepository.findOneById(favoritesDTOS.get(i).getShopitem_id());
            item.setLove_status(1);
            item.setAvatar(documentRepository.getByShopItemIdAndAndPriority(item.getId(), 1).getLink());
            shopItemDTOS.add(item);
        }

        return shopItemDTOS;
    }

    @Override
    public List<ShopItemDTO> findAllByCategory(Integer categoryId, Integer offset) {
        return updateInfors(dtoShopItemRepository.findAllByCategory(categoryId, offset, Contants.LIMIT));
    }

    @Override
    public List<ShopItem> findAllByShopIdHadComment(Integer shop_id, Integer id) {
        return shopItemRepository.findAllByShopIdAndComment_numberGreaterThanAndIdNot(shop_id, 0, id);
    }

    @Override
    public Double getRatingByShopItemId(Integer id) {
        return shopItemRepository.getRatingById(id);
    }

    @Override
    public ShopItemDTO getOneDTO(Integer id) {
        ShopItemDTO shopItemDTO = dtoShopItemRepository.findOneById(id);
        Document document = documentRepository.getByShopItemIdAndAndPriority(shopItemDTO.getId(), 1);
        if (document != null) {
            shopItemDTO.setAvatar(document.getLink());
        } else {
            shopItemDTO.setAvatar("full_logo.jpg");
        }

        return shopItemDTO;
    }


    @Override
    public List<ShopItemDTO> getAllByShopId(Integer id, Integer offset, Integer limit) {
        return updateInfors(dtoShopItemRepository.getAllByShopId(id, offset, limit));
    }


    @Override
    public List<ShopItemDTO> getHighRatingItem(Integer offset) {
        return updateInfors(dtoShopItemRepository.getHighRatingItem(offset, Contants.LIMIT));
    }

    public List<ShopItemDTO> updateLove_Status(List<ShopItemDTO> shopItemDTOS, Integer userId) {
        for (int i = 0; i < shopItemDTOS.size(); i++ ) {
            if ( favoritesRepository.findByShopItemIdAndUserIdAndStatus(shopItemDTOS.get(i).getId(), userId, 1) != null) {

                shopItemDTOS.get(i).setLove_status(1);
            } else {
                shopItemDTOS.get(i).setLove_status(0);
            }
        }
        return shopItemDTOS;
    }

    public List<ShopItemDTO> updateInfors(List<ShopItemDTO> shopItemDTOS) {
        for (int i = 0; i < shopItemDTOS.size(); i++) {
            Document document = documentRepository.getByShopItemIdAndAndPriority(shopItemDTOS.get(i).getId(), 1);
            if (document != null) {
                shopItemDTOS.get(i).setAvatar(document.getLink());
            } else {
                shopItemDTOS.get(i).setAvatar("full_logo.jpg");
            }
        }

        return shopItemDTOS;
    }
}
