package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query(value = "select * from shop limit ?1 offset ?2", nativeQuery = true)
    List<Shop> findOrOrderByRating(Integer limit, Integer offset);
}
