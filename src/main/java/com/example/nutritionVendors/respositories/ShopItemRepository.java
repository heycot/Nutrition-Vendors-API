package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {

    @Query(value = "select * from shopitem order by rating DESC limit ?1", nativeQuery = true)
    List<ShopItem> getHighRatingItem(Integer start);


}
