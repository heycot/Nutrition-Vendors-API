package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {

    Integer countByShopItemId(Integer id);

    Favorites findByShopItemIdAndUserId(Integer shopItemId, Integer userId);
}
