package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.User;

import java.util.List;

public interface FavoritesService {

    FavoritesDTO loveOne(Integer id, Integer userId);

    List<FavoritesDTO> findAllByuserId(Integer userId);


    List<FavoritesDTO> findAllByuserLoved(Integer userId);

    Favorites getLoveStatus(Integer shopitem_id, User user);
}
