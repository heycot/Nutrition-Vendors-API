package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Document, Integer> {
}
