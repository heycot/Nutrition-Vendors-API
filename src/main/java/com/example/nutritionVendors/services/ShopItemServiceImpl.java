package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.respositories.*;
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
    public List<ShopItemDTO> searchItem(String searchText, Integer userId) {
        List<ShopItemDTO> itemDTOList = dtoShopItemRepository.searchItem("%" +searchText + " %");
        List<ShopItemDTO> itemDTOList1 = dtoShopItemRepository.searchItem("% " +searchText + " %");
        for (int i =0 ; i < itemDTOList1.size(); i++) {
            if ( !checkItemInList(itemDTOList, itemDTOList1.get(i)) ) {
                itemDTOList.add(itemDTOList1.get(i));
            }
        }

        List<ShopItemDTO> itemDTOList2 = dtoShopItemRepository.searchItem("%" +searchText + "%");
        for (int i =0 ; i < itemDTOList2.size(); i++) {
            if ( !checkItemInList(itemDTOList, itemDTOList2.get(i)) ) {
                itemDTOList.add(itemDTOList2.get(i));
            }
        }

        itemDTOList = reSortListWithSearch(itemDTOList, searchText);

        return updateInfors(itemDTOList, userId);
    }

    public List<ShopItemDTO> reSortListWithSearch(List<ShopItemDTO> array, String searchText) {
        List<ShopItemDTO> list = new ArrayList<>();

        for (int i = 0; i < array.size(); i++ ) {
            if ( array.get(i).getName().toLowerCase() == searchText && !checkItemInList(list, array.get(i))) {
                list.add(array.get(i));
            }

        }

        for (int i = 0; i < array.size(); i++ ) {

            if ( array.get(i).getName().toLowerCase().contains(searchText) && !checkItemInList(list, array.get(i))) {
                list.add(array.get(i));
            }
        }

        for (int i = 0; i < array.size(); i++ ) {

            if (  !checkItemInList(list, array.get(i))) {
                list.add(array.get(i));
            }
        }

        return list;
    }

    public Boolean checkItemInList(List<ShopItemDTO> itemDTOS, ShopItemDTO itemDTO) {
        for (int i  = 0; i < itemDTOS.size(); i++){
            if (itemDTO.getId() == itemDTOS.get(i).getId()) {
                return true;
            }
        }

        return false;
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
    public List<ShopItemDTO> findAllByCategory(Integer categoryId, Integer userId, Integer offset) {
        return updateInfors(dtoShopItemRepository.findAllByCategory(categoryId, offset, Contants.LIMIT), userId);
    }

    @Override
    public List<ShopItem> findAllByShopIdHadComment(Integer shop_id, Integer id) {
        return shopItemRepository.findAllByShopIdAndComment_numberGreaterThanAndIdNot(shop_id, 0, id);
    }


    @Override
    public List<ShopItemDTO> getAllByShopId(Integer id, Integer limit, Integer offset, Integer userId) {
        List<ShopItemDTO> shopItemDTOS = dtoShopItemRepository.getAllByShopId(id, limit, offset);

        if (userId > 0) {
            shopItemDTOS = updateLove_Status(shopItemDTOS, userId);
        }

        return shopItemDTOS;
    }


    @Override
    public List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset, Integer userId) {
        return updateInfors(dtoShopItemRepository.getHighRatingItem(limit, offset), userId);
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

    public List<ShopItemDTO> updateInfors(List<ShopItemDTO> shopItemDTOS, Integer userId) {
        for (int i = 0; i < shopItemDTOS.size(); i++) {
            Document document = documentRepository.getByShopItemIdAndAndPriority(shopItemDTOS.get(i).getId(), 1);
            if (document != null) {
                shopItemDTOS.get(i).setAvatar(document.getLink());
            } else {
                shopItemDTOS.get(i).setAvatar("full_logo.jpg");
            }
        }

        if (userId >0 ){
            shopItemDTOS = updateLove_Status(shopItemDTOS, userId);
        }
        return shopItemDTOS;
    }
}
