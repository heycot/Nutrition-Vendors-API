package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import com.example.nutritionVendors.entities.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {


    @Query(value = "select shopitem.id, shopitem.rating, shopitem.status, shopitem.price, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name, category.name as category_name, " +
            " (select link from document inner join shopitem on document.shopitem_id = shopitem.id limit 1) as avatar " +
            " from shopitem inner join comment on shopitem.id = comment.shopitem_id " +
            " inner join favorites on shopitem.id = favorites.shopitem_id" +
            " inner join item on shopitem.item_id = item.id" +
            " left join category on item.category_id = category.id " +
            " group by shopitem.id, item.name, category.name order by shopitem.rating desc limit ?1", nativeQuery = true)
    List<ShopItemDTO> getHighRatingItem(Integer start);


    @Query(value = "select * from shopitem order by rating desc limit ?1", nativeQuery = true)
    List<ShopItem> findHighRatingItem(Integer start);


}
