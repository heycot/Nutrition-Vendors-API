package com.example.nutritionVendors.DTORepositories;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemDTORepository  extends JpaRepository<ShopItemDTO, Integer> {


    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name from shopitem " +
            " left join comment on shopitem.id = comment.shopitem_id " +
            " left join favorites on shopitem.id = favorites.shopitem_id" +
            " left join item on shopitem.item_id = item.id" +
            " group by shopitem.id, item.name where shopitem.status = 1 order by shopitem.rating desc limit ?1 offset ?2", nativeQuery = true)
    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset);
}
