package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.RecentSearch;
import com.example.nutritionVendors.entities.User;

import java.util.List;

public interface RecentSearchService {

    RecentSearch updateOneByEntityId(Integer entity_id, Integer is_shop, User user);


    List<RecentSearch> findAllByUser(Integer id, Integer offset, Integer limit);

}
