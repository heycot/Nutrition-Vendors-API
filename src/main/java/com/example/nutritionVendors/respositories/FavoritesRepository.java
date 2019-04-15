package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.User;
import com.sun.imageio.plugins.common.I18N;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {

    Integer countByShopItemId(Integer shopitem_id);

    Favorites findByShopItemIdAndUserIdAndStatus(Integer shopItemId, Integer userId, Integer status);

    Favorites findByShopItemIdAndUserId(Integer shopItemId, Integer userId);

    @Query(value = "select * from favorites where shopitem_id = ?1 and user_id = ?3 and status = ?2", nativeQuery = true)
    Favorites findByShopItemIdAndStatusAndUserId(Integer shopitem_id, Integer status, Integer user_id);

}
