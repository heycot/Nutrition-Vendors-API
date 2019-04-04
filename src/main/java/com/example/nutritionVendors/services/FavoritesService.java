package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import com.example.nutritionVendors.entities.Favorites;

import java.util.List;

public interface FavoritesService {

    FavoritesDTO loveOne(Integer id, Integer userId, Integer status);

    List<FavoritesDTO> findAllByuserId(Integer userId);
}
