package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {
}
