package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DTOShopItemRepository extends JpaRepository<ShopItemDTO, Integer> {


    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name, " +
            " (select link from document left join shopitem on document.shopitem_id = shopitem.id limit 1 ) as avatar from shopitem " +
            " left join comment on shopitem.id = comment.shopitem_id " +
            " left join favorites on shopitem.id = favorites.shopitem_id" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " group by shopitem.id, item.name order by shopitem.rating desc limit ?1 offset ?2", nativeQuery = true)
    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset);


    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name, " +
            " (select link from document left join shopitem on document.shopitem_id = shopitem.id limit 1 ) as avatar from shopitem " +
            " left join comment on shopitem.id = comment.shopitem_id " +
            " left join favorites on shopitem.id = favorites.shopitem_id" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " where shopitem.shop_id = ?1" +
            " group by shopitem.id, item.name order by shopitem.rating desc limit ?2 offset ?3", nativeQuery = true)
    List<ShopItemDTO> getAllByShopId(Integer shopId, Integer limit, Integer offset);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name, " +
            " (select link from document left join shopitem on document.shopitem_id = shopitem.id limit 1 ) as avatar from shopitem " +
            " left join comment on shopitem.id = comment.shopitem_id " +
            " left join favorites on shopitem.id = favorites.shopitem_id" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " group by shopitem.id, item.name ", nativeQuery = true)
    ShopItemDTO getOneById(Integer id);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name, " +
            " (select link from document left join shopitem on document.shopitem_id = shopitem.id limit 1 ) as avatar from shopitem " +
            " left join comment on shopitem.id = comment.shopitem_id " +
            " left join favorites on shopitem.id = favorites.shopitem_id" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " where item.name like ?1" +
            " group by shopitem.id, item.name " , nativeQuery = true)
    List<ShopItemDTO> searchItem(String searchText);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
            " count (comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
            " count (favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
            " item.name as name, " +
            " (select link from document left join shopitem on document.shopitem_id = shopitem.id limit 1 ) as avatar from shopitem " +
            " left join comment on shopitem.id = comment.shopitem_id " +
            " left join favorites on shopitem.id = favorites.shopitem_id" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " group by shopitem.id, item.name " , nativeQuery = true)
    List<ShopItemDTO> getAll();
}
