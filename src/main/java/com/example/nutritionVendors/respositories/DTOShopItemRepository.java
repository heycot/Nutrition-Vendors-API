package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.ShopItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DTOShopItemRepository extends JpaRepository<ShopItemDTO, Integer> {

//
//    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, " +
//            " count(comment.id in (select comment.id from comment where comment.shopitem_id = shopitem.id)) as comment_number, " +
//            " count(favorites.id in (select favorites.id from favorites where favorites.shopitem_id = shopitem.id)) as favorites_number," +
//            " item.name as name, shop.name as shop_name, " +
//            " (select link from document left join shopitem on document.shopitem_id = shopitem.id limit 1 ) as avatar from shopitem " +
//            " left join comment on shopitem.id = comment.shopitem_id " +
//            " left join favorites on shopitem.id = favorites.shopitem_id" +
//            " left join item on shopitem.item_id = item.id" +
//            " left join document on shopitem.id = document.shopitem_id" +
//            " left join shop on shopitem.shop_id = shop.id " +
//            " group by shopitem.id, item.name, shop.name order by shopitem.rating desc limit ?1, ?2", nativeQuery = true)
//    List<ShopItemDTO> getHighRatingItem(Integer limit, Integer offset);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit from shopitem" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " group by shopitem.id, item.name, shop.name order by shopitem.comment_number desc, shopitem.rating desc limit ?1, ?2", nativeQuery = true)
    List<ShopItemDTO> getHighRatingItem(Integer offset, Integer limit);


    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit from shopitem" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " where shopitem.shop_id = ?1" +
            " group by shopitem.id, item.name, shop.name order by shopitem.comment_number desc, shopitem.rating desc limit ?2, ?3", nativeQuery = true)
    List<ShopItemDTO> getAllByShopId(Integer shopId, Integer offset, Integer limit);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit from shopitem" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " group by shopitem.id, item.name, shop.name ", nativeQuery = true)
    ShopItemDTO getOneById(Integer id);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit  from shopitem" +
            " inner join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " where item.name like  CONCAT('%', ?1, '%')  or l.address like CONCAT('%',?1, '%')" +
            " group by shopitem.id, item.name, shop.name " , nativeQuery = true)
    List<ShopItemDTO> searchItem(byte[] searchText);


    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit  from shopitem" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " group by shopitem.id, item.name, shop.name order by shopitem.comment_number desc, shopitem.rating desc " , nativeQuery = true)
    List<ShopItemDTO> getAll();

    @Query(value = "select link from document  where shopitem_id = ?1 limit 1", nativeQuery = true)
    String findAvatarById(Integer id);


    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit  from shopitem" +
            " left join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " where shopitem.id = ?1", nativeQuery = true)
    ShopItemDTO findOneById(Integer shopitem_id);

    @Query(value = "select shopitem.id, shopitem.price, shopitem.status, shopitem.rating, shopitem.comment_number, shopitem.favorites_number," +
            " item.name as name, shop.name as shop_name,  '' as avatar, 0 as love_status, l.address as address, m.sign as unit  from shopitem" +
            " inner join item on shopitem.item_id = item.id" +
            " left join document on shopitem.id = document.shopitem_id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " left join measure m on item.measure_id = m.id " +
            " where item.category_id = ?1" +
            " group by shopitem.id, item.name, shop.name order by shopitem.comment_number desc, shopitem.rating desc limit ?2, ?3", nativeQuery = true)
    List<ShopItemDTO> findAllByCategory(Integer categoryId, Integer offset, Integer limit);
}
