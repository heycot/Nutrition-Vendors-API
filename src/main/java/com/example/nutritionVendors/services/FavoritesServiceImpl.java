package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.respositories.DTOFavoritesRepository;
import com.example.nutritionVendors.respositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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

        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        Favorites favorites = favoritesRepository.findByShopItemIdAndUserId(id, userId);
        ShopItem shopItem = shopItemService.getOne(id);

        if (favorites == null) {
            favorites = new Favorites();
            favorites.setId(0);
            favorites.setStatus(1);

            favorites.setUser(userService.getOneById(userId));
            favorites.setCreate_date(ts);
            favorites.setUpdate_date(ts);

            shopItem.setFavorites_number(shopItem.getFavorites_number() + 1);

            favorites = favoritesRepository.save(favorites);
        } else {


            if (favorites.getStatus() == 1) {
                favorites.setStatus(0);
                shopItem.setFavorites_number(shopItem.getFavorites_number() - 1);
            } else {
                favorites.setStatus(1);
                shopItem.setFavorites_number(shopItem.getFavorites_number() + 1);
            }

            favorites.setUpdate_date(ts);
            favoritesRepository.save(favorites);
        }

        return new FavoritesDTO(favorites.getId(), favorites.getShopItem().getId(), favorites.getUser().getId(), favorites.getStatus(), favorites.getCreate_date(), favorites.getUpdate_date());
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
