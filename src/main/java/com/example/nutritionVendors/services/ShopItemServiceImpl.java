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
    public List<ShopItemDTO> searchItem(String searchText, Integer userId) {

        String[] searchTexts =  searchText.split(" ");
        List<ShopItemDTO> resultSearch = new ArrayList<>();

        for (int i = 0; i < searchTexts.length; i++) {
            List<ShopItemDTO> list = searchByOneWord(searchTexts[i]);
            resultSearch = addListToList(resultSearch, list);
        }


        resultSearch = SortListWithSearch(resultSearch, searchTexts);

        return updateInfors(resultSearch, userId);
    }



    public List<ShopItemDTO> searchByOneWord(String searchText) {
        byte[] searchBinary1 = ( " " + searchText + " ").getBytes(StandardCharsets.UTF_8);
        byte[] searchBinary2 = ( searchText + " ").getBytes(StandardCharsets.UTF_8);
        byte[] searchBinary3 = ( " " + searchText ).getBytes(StandardCharsets.UTF_8);

        //search with regex one
        List<ShopItemDTO> itemDTOList = dtoShopItemRepository.searchItem(searchBinary1);

        //search with regex two and add to list
        List<ShopItemDTO> itemDTOList1 = dtoShopItemRepository.searchItem(searchBinary2);
        itemDTOList = addListToList(itemDTOList, itemDTOList1);

        // search with regex three and all to list
        List<ShopItemDTO> itemDTOList2 = dtoShopItemRepository.searchItem(searchBinary3);
        itemDTOList = addListToList(itemDTOList, itemDTOList2);

        return itemDTOList;

    }

    public List<ShopItemDTO> addListToList(List<ShopItemDTO> arrWillAdd, List<ShopItemDTO> arr) {
        for (int i =0 ; i < arr.size(); i++) {
            if ( !checkItemInList(arrWillAdd, arr.get(i)) ) {
                arrWillAdd.add(arr.get(i));
            }
        }

        return arrWillAdd;
    }

    public List<ShopItemDTO> SortListWithSearch(List<ShopItemDTO> array, String[] searchText) {
        Integer max = searchText.length;

        List<ShopItemDTO> result = new ArrayList<>();

        while (max >= 0 && result.size() < 20) {
            for ( int i  = 0; i < array.size(); i++) {
                if ( countNumberContainsInObjectBySearch(array.get(i), searchText) >= max && !checkItemInList(result, array.get(i))) {
                    result.add(array.get(i));
                }
            }

            max--;
        }

        return result;
    }

    public Integer countNumberContainsInObjectBySearch(ShopItemDTO item, String[] searchText) {
        Integer count = 0;

        for ( int i = 0; i < searchText.length; i++) {
            if (checkExists(item.getName(), searchText[i]) || checkExists(item.getShop_name(), searchText[i]) || checkExists(item.getAddress(), searchText[i])) {
                count++;
            }
        }

        return count;
    }

    public boolean checkExists(String property, String searchText) {
        property = property.toLowerCase();
        if ( property.toLowerCase().contains(" " + searchText + " ") || property.toLowerCase().contains(searchText + " ") || property.toLowerCase().contains(" " + searchText)) {
            return true;
        }
        return false;
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
    public Double getRatingByShopItemId(Integer id) {
        return shopItemRepository.getRatingById(id);
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
