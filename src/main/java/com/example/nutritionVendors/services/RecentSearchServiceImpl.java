package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.RecentSearch;
import com.example.nutritionVendors.respositories.RecentSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecentSearchServiceImpl implements RecentSearchService {

    @Autowired
    private RecentSearchRepository recentSearchRepository;


    @Override
    public RecentSearch addOne(RecentSearch recentSearch) {
//        if ( recentSearchRepository.saveOne(recentSearch.getEntity_id(), recentSearch.getUser().getId(), recentSearch.getIs_shop()) != null) {
//            return recentSearch;
//        }
//
//        return null;

        return recentSearchRepository.save(recentSearch);
    }

    @Override
    public List<RecentSearch> findAllByUser(Integer id, Integer offset, Integer limit) {
        return recentSearchRepository.findAllByUserId(id, offset, limit);
    }
}
