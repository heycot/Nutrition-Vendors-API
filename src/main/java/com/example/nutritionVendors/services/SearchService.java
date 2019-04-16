package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.SearchDTO;
import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.respositories.DTOShopItemRepository;
import com.example.nutritionVendors.respositories.DocumentRepository;
import com.example.nutritionVendors.respositories.SearchDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private DTOShopItemRepository dtoShopItemRepository;

    @Autowired
    private SearchDTORepository searchDTORepository;

    @Autowired
    private DocumentRepository documentRepository;


    public List<SearchDTO> searchItem(String searchText) {

        String[] searchTexts =  searchText.split(" ");
        List<SearchDTO> resultSearch = new ArrayList<>();

        for (int i = 0; i < searchTexts.length; i++) {
            List<SearchDTO> list = searchShop(searchTexts[i]);
            resultSearch = addListToList(resultSearch, list);
        }


        resultSearch = SortListWithSearch(resultSearch, searchTexts);


        if (countNumberContainsInObjectBySearch(resultSearch.get(0), searchTexts) < searchTexts.length) {
            resultSearch = new ArrayList<>();
            for (int i = 0; i < searchTexts.length; i++) {
                List<SearchDTO> list = searchFood(searchTexts[i]);
                resultSearch = addListToList(resultSearch, list);
            }
        }
        resultSearch = SortListWithSearch(resultSearch, searchTexts);

        return updateInfors(resultSearch);
    }

    public List<SearchDTO> searchFood(String searchText) {

        byte[] searchBinary1 = ( " " + searchText + " ").getBytes(StandardCharsets.UTF_8);
        byte[] searchBinary2 = ( searchText + " ").getBytes(StandardCharsets.UTF_8);
        byte[] searchBinary3 = ( " " + searchText ).getBytes(StandardCharsets.UTF_8);

        //search with regex one
        List<SearchDTO> itemDTOList = searchDTORepository.searchFood(searchBinary1);

        //search with regex two and add to list
        List<SearchDTO> itemDTOList1 = searchDTORepository.searchFood(searchBinary2);
        itemDTOList = addListToList(itemDTOList, itemDTOList1);

        // search with regex three and all to list
        List<SearchDTO> itemDTOList2 = searchDTORepository.searchFood(searchBinary3);
        itemDTOList = addListToList(itemDTOList, itemDTOList2);


        return itemDTOList;

    }


    public List<SearchDTO> searchShop(String searchText) {
        byte[] searchBinary1 = ( " " + searchText + " ").getBytes(StandardCharsets.UTF_8);
        byte[] searchBinary2 = ( searchText + " ").getBytes(StandardCharsets.UTF_8);
        byte[] searchBinary3 = ( " " + searchText ).getBytes(StandardCharsets.UTF_8);

        //search with regex one
        List<SearchDTO> itemDTOList = searchDTORepository.searchShop(searchBinary1);

        //search with regex two and add to list
        List<SearchDTO> itemDTOList1 = searchDTORepository.searchShop(searchBinary2);
        itemDTOList = addListToList(itemDTOList, itemDTOList1);

        // search with regex three and all to list
        List<SearchDTO> itemDTOList2 = searchDTORepository.searchShop(searchBinary3);
        itemDTOList = addListToList(itemDTOList, itemDTOList2);


        return itemDTOList;

    }

    public List<SearchDTO> addListToList(List<SearchDTO> arrWillAdd, List<SearchDTO> arr) {
        for (int i =0 ; i < arr.size(); i++) {
            if ( !checkItemInList(arrWillAdd, arr.get(i)) ) {
                arrWillAdd.add(arr.get(i));
            }
        }

        return arrWillAdd;
    }


    public List<SearchDTO> SortListWithSearch(List<SearchDTO> array, String[] searchText) {
        Integer max = searchText.length;

        List<SearchDTO> result = new ArrayList<>();

        while (max >= 0 && result.size() < 30) {
            for ( int i  = 0; i < array.size(); i++) {
                if ( countNumberContainsInObjectBySearch(array.get(i), searchText) >= max && !checkItemInList(result, array.get(i))) {
                    result.add(array.get(i));
                }
            }

            max--;
        }

        return result;
    }

    public Integer countNumberContainsInObjectBySearch(SearchDTO item, String[] searchText) {
        Integer count = 0;

        for ( int i = 0; i < searchText.length; i++) {
            if (checkExists(item.getEntity_name(), searchText[i]) || checkExists(item.getAddress(), searchText[i])) {
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



    public Boolean checkItemInList(List<SearchDTO> itemDTOS, SearchDTO itemDTO) {
        for (int i  = 0; i < itemDTOS.size(); i++){
            if (itemDTO.getId() == itemDTOS.get(i).getId()) {
                return true;
            }
        }

        return false;
    }

    public List<SearchDTO> updateInfors(List<SearchDTO> shopItemDTOS) {
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
