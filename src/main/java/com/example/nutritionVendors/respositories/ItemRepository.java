package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByCategoryId(Integer category_id);
}
