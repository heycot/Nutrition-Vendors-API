package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.SearchDTO;
import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.entities.RecentSearch;
import com.example.nutritionVendors.library.StringLibrary;
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
    private SearchDTORepository searchDTORepository;

    @Autowired
    private DocumentRepository documentRepository;


    public List<SearchDTO> searchItem(String searchText) {
        // check searchText có dấu
        Boolean isPunctuation = true;
        isPunctuation = StringLibrary.checkAccent(searchText) ? true : false;

        String[] searchTexts =  searchText.split(" ");
        Boolean isShop = true;
        List<SearchDTO> resultSearch = new ArrayList<>();

        for (int i = 0; i < searchTexts.length; i++) {
            List<SearchDTO> list = searchShop(searchTexts[i], isPunctuation);
            resultSearch = addListToList(resultSearch, list);
        }


        resultSearch = SortListWithSearch(resultSearch, searchTexts, isPunctuation);


        if (resultSearch.size() > 0) {
            if (countNumberContainsInObjectBySearch(resultSearch.get(0), searchTexts, isPunctuation) < searchTexts.length) {
                resultSearch = getListSearchFood(searchTexts);
                isShop = false;
            }
        } else {
            resultSearch = getListSearchFood(searchTexts);
            isShop = false;
        }

        resultSearch = SortListWithSearch(resultSearch, searchTexts, isPunctuation);
        System.out.println( "size for search: " + resultSearch.size());

        if ( isShop ) {
            return resultSearch;
        } else {
            return updateInfors(resultSearch);
        }
    }

    public List<SearchDTO> getListSearchFood(String[] searchTexts) {
        List<SearchDTO> resultSearch = new ArrayList<>();
        for (int i = 0; i < searchTexts.length; i++) {
            List<SearchDTO> list = searchFood(searchTexts[i], true);
            resultSearch = addListToList(resultSearch, list);
        }

//        if (resultSearch.size() == 0) {
            for (int i = 0; i < searchTexts.length; i++) {
                List<SearchDTO> list = searchFood(searchTexts[i], false);
                resultSearch = addListToList(resultSearch, list);
            }
//        }

        return resultSearch;
    }

    public List<SearchDTO> searchFood(String searchText, Boolean isPunctuation) {
        List<SearchDTO> itemDTOList = new ArrayList<>();


        // search with punctuation
        if ( isPunctuation ) {
            byte[][] regexs = getRegexString(searchText);

            //search with regex one
            itemDTOList = searchDTORepository.searchFood(regexs[0]);

            //search with regex two and add to list
            List<SearchDTO> itemDTOList1 = searchDTORepository.searchFood(regexs[1]);
            itemDTOList = addListToList(itemDTOList, itemDTOList1);

            // search with regex three and all to list
            List<SearchDTO> itemDTOList2 = searchDTORepository.searchFood(regexs[2]);
            itemDTOList = addListToList(itemDTOList, itemDTOList2);
        } else {

            //search without punctuation
            itemDTOList = searchDTORepository.searchFoodNoPunctuation(searchText);
        }

        return itemDTOList;

    }


    public List<SearchDTO> searchShop(String searchText, Boolean isPunctuation) {
        List<SearchDTO> itemDTOList = new ArrayList<>();

        if ( isPunctuation ) {
            byte[][] regexs = getRegexString(searchText);

            //search with regex one
            itemDTOList = searchDTORepository.searchShop(regexs[0]);

            //search with regex two and add to list
            List<SearchDTO> itemDTOList1 = searchDTORepository.searchShop(regexs[1]);
            itemDTOList = addListToList(itemDTOList, itemDTOList1);

            // search with regex three and all to list
            List<SearchDTO> itemDTOList2 = searchDTORepository.searchShop(regexs[2]);
            itemDTOList = addListToList(itemDTOList, itemDTOList2);

        } else {

            //search with regex one
//            itemDTOList = searchDTORepository.searchFoodNoPunctuation( " " + searchText + " ");
//
//            //search with regex two and add to list
//            List<SearchDTO> itemDTOList1 = searchDTORepository.searchFoodNoPunctuation(searchText + " ");
//            itemDTOList = addListToList(itemDTOList, itemDTOList1);
//
//            // search with regex three and all to list
//            List<SearchDTO> itemDTOList2 = searchDTORepository.searchFoodNoPunctuation(" " + searchText);
//            itemDTOList = addListToList(itemDTOList, itemDTOList2);

            itemDTOList = searchDTORepository.searchFoodNoPunctuation(searchText);
        }

        return itemDTOList;

    }

    public byte[][] getRegexString(String searchText) {
        byte[][] result = new byte[3][];

        result[0] = ( " " + searchText + " ").getBytes(StandardCharsets.UTF_8);
        result[1] = ( searchText + " ").getBytes(StandardCharsets.UTF_8);
        result[2] = ( " " + searchText ).getBytes(StandardCharsets.UTF_8);

        return result;
    }

    public List<SearchDTO> addListToList(List<SearchDTO> arrWillAdd, List<SearchDTO> arr) {
        for (int i =0 ; i < arr.size(); i++) {
            if ( !checkItemInList(arrWillAdd, arr.get(i)) ) {
                arrWillAdd.add(arr.get(i));
            }
        }

        return arrWillAdd;
    }


    public List<SearchDTO> SortListWithSearch(List<SearchDTO> array, String[] searchText, Boolean isPunctuation) {
        Integer max = searchText.length;

        List<SearchDTO> result = new ArrayList<>();

        while ( max > 0) {
            for ( int i  = 0; i < array.size(); i++) {
                if ( result.size() > 30) {
                    break;
                }

                if ( countNumberContainsInObjectBySearch(array.get(i), searchText, isPunctuation) >= max && !checkItemInList(result, array.get(i))) {
                    result.add(array.get(i));
                }
            }

            max--;
        }

//        max = searchText.length;
//        while (result.size() < 30 ) {
//            for ( int i  = 0; i < array.size(); i++) {
//                if ( countNumberContainsInObjectBySearch(array.get(i), searchText, false) >= max && !checkItemInList(result, array.get(i))) {
//                    result.add(array.get(i));
//                }
//            }
//            break;
//
//        }

        return result;
    }

    public Integer countNumberContainsInObjectBySearch(SearchDTO item, String[] searchText, Boolean isPunctuation) {
        Integer count = 0;

//        if ( isPunctuation ) {
            for ( int i = 0; i < searchText.length; i++) {
                if ( StringLibrary.checkAccent(searchText[i]) ) {
                    if (checkExistsWithPunctuation(item.getEntity_name(), searchText[i]) || checkExistsWithPunctuation(item.getAddress(), searchText[i])) {
                        count++;
                    }
                } else {
                    if (checkExistsNoPunctuation(item.getEntity_name(), searchText[i]) || checkExistsNoPunctuation(item.getAddress(), searchText[i])) {
                        count++;
                    }
                }

            }
//        }
//        else {
//            for ( int i = 0; i < searchText.length; i++) {
//                if (checkExistsNoPunctuation(item.getEntity_name(), searchText[i]) || checkExistsNoPunctuation(item.getAddress(), searchText[i])) {
//                    count++;
//                }
//            }
//        }

        return count;
    }

    public boolean checkExistsWithPunctuation(String property, String searchText) {
        property = property.toLowerCase();
        if ( property.toLowerCase().contains(searchText)) {
            return true;
        }
        return false;
    }

    public boolean checkExistsNoPunctuation(String property, String searchText) {
        property = property.toLowerCase();
            if ( StringLibrary.removeAccent(property).toLowerCase().contains(StringLibrary.removeAccent(searchText))) {
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

    public List<SearchDTO> findAllByUser(List<RecentSearch> recentSearches) {

        List<SearchDTO> results =  new ArrayList<>();
        SearchDTO item = new SearchDTO();
        Document document = new Document();

        for(int i = 0; i < recentSearches.size(); i++) {

            if ( recentSearches.get(i).getIs_shop() == 0) {
                item = searchDTORepository.searchFoodById(recentSearches.get(i).getEntity_id());
                document = documentRepository.getByShopItemIdAndAndPriority(item.getId(), 1);
                item.setAvatar(document.getLink());
                results.add(item);
            } else {
                results.add(searchDTORepository.searchShopById(recentSearches.get(i).getEntity_id()));
            }
        }

        return results;
    }
}
