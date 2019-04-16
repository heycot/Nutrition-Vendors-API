package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.SearchDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDTORepository extends JpaRepository<SearchDTO, Integer> {


    @Query(value = "select shop.id as id, shop.id as entity_id, shop.name as entity_name, shop.rating , shop.comment_number as comment_number, " +
            "  shop.avatar as avatar, l.address as address, 0 as isShop from shop " +
            "  left join location l on shop.location_id = l.id " +
            "  where  shop.name like CONCAT('%', ?1 , '%') or l.address like CONCAT('%', ?1 , '%')" , nativeQuery = true)
    List<SearchDTO> searchShop(byte[] searchText);

    @Query(value = "select shopitem.id as id, shopitem.id as entity_id, item.name as entity_name,  shopitem.rating, shopitem.comment_number, " +
            " '' as avatar, l.address as address, 1 as isShop from shopitem" +
            " inner join item on shopitem.item_id = item.id" +
            " left join shop on shopitem.shop_id = shop.id " +
            " left join location l on shop.location_id = l.id " +
            " where  item.name like CONCAT('%', ?1, '%') or l.address like CONCAT('%',?1, '%')" +
            " group by shopitem.id, item.name, shop.name " , nativeQuery = true)
    List<SearchDTO> searchFood(byte[] searchText);
}
