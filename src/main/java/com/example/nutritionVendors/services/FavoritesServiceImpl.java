package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.respositories.DTOFavoritesRepository;
import com.example.nutritionVendors.respositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private DTOFavoritesRepository DTOFavoritesRepository;

    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private UserService userService;

    @Override
    public FavoritesDTO loveOne(Integer id, Integer userId) {
        Favorites favorites = favoritesRepository.findByShopItemIdAndUserId(id, userId);

        if (favorites == null) {
            favorites = new Favorites();
            favorites.setId(0);
            favorites.setStatus(1);
            favorites.setShopItem(shopItemService.getOne(id));
            favorites.setUser(userService.getOneById(userId));

            favorites = favoritesRepository.save(favorites);
        } else {
            if (favorites.getStatus() == 1) {
                favorites.setStatus(0);
            } else {
                favorites.setStatus(1);
            }

            favoritesRepository.save(favorites);
        }

        return new FavoritesDTO(favorites.getId(), favorites.getShopItem().getId(), favorites.getUser().getId(), favorites.getStatus());
    }

    @Override
    public List<FavoritesDTO> findAllByuserId(Integer userId) {
        return DTOFavoritesRepository.findAllByUser_id(userId);
    }

    @Override
    public List<FavoritesDTO> findAllByuserLoved(Integer userId) {
        return null;
    }

    @Override
    public Favorites getLoveStatus(Integer shopitem_id, User user) {
        return favoritesRepository.findByShopItemIdAndStatusAndUserId(shopitem_id, 1, user.getId());
    }
}
