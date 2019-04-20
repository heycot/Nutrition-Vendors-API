package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.RecentSearch;

import java.util.List;

public interface RecentSearchService {

    RecentSearch addOne(RecentSearch recentSearch);

    List<RecentSearch> findAllByUser(Integer id, Integer offset, Integer limit);
}
