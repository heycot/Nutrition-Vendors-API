package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.RecentSearch;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.respositories.RecentSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class RecentSearchServiceImpl implements RecentSearchService {

    @Autowired
    private RecentSearchRepository recentSearchRepository;


    @Override
    public RecentSearch updateOneByEntityId(Integer entity_id, Integer is_shop, User user) {
//        if ( recentSearchRepository.saveOne123(entity_id, is_shop, user.getId()) > 0) {
//            return null;
//        }
//
//        return null;


        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        RecentSearch recentSearch;

         recentSearch = recentSearchRepository.findByEntity_idAndIs_shopAndUser(entity_id, is_shop, user.getId());

        if ( recentSearch != null) {
            recentSearch.setUpdate_date(ts);
        } else {
            recentSearch  = new RecentSearch();
            recentSearch.setId(0);
            recentSearch.setEntity_id(entity_id);
            recentSearch.setIs_shop(is_shop);
            recentSearch.setUser(user);
            recentSearch.setCreate_date(ts);
            recentSearch.setUpdate_date(ts);
        }

        return recentSearchRepository.save(recentSearch);
    }

    @Override
    public List<RecentSearch> findAllByUser(Integer id, Integer offset, Integer limit) {
        return recentSearchRepository.findAllByUserId(id, offset, limit);
    }
}
