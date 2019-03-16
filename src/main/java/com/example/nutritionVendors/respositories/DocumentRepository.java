package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    @Query(value = "select * from document where document.shopitem_id = ?1", nativeQuery = true)
    List<Document> findAllByShopItemId(long id);

//    Document findOneByShopItemId(Integer id);

    Document getFirstByShopItem_Id(Integer id);
}
