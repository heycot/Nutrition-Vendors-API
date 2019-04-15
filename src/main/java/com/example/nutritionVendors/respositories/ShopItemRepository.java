package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {

    @Query(value = "select * from shopitem order by rating desc limit ?1 offset ?2", nativeQuery = true)
    List<ShopItem> findHighRatingItem(Integer start, Integer offset);

    @Query(value = "select * from shopitem where id = ?1", nativeQuery = true)
    ShopItem findOneById(Integer id);

    @Query(value = "select * from  shopitem where shop_id = ?1 and comment_number > ?2 and id != ?3", nativeQuery = true)
    List<ShopItem> findAllByShopIdAndComment_numberGreaterThanAndIdNot(Integer shop_id, Integer comment_number, Integer id);

    @Query(value = "select rating from shopitem where id = ?1", nativeQuery = true)
    Double getRatingById(Integer id);
}
