package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query(value = "select * from shop limit ?1 offset ?2 oder by rating desc ", nativeQuery = true)
    List<Shop> findOrOrderByRating(Integer limit, Integer offset);

    @Query(value = "SELECT shop.* , ( ACOS( COS( RADIANS( ?1  ) ) " +
            "              * COS( RADIANS( latitude ) )" +
            "              * COS( RADIANS( longitude) - RADIANS( ?2 ) )" +
            "              + SIN( RADIANS( ?1  ) )" +
            "              * SIN( RADIANS( latitude ) ) ) * 6371) AS distance_in_km" +
            "  FROM shop inner join location on shop.location_id = location.id " +
            " ORDER BY distance_in_km ASC" +
            " LIMIT ?3, ?4", nativeQuery = true)
    List<Shop> findNearestUserLocation(Double latitude, Double longitude, Integer offset, Integer limit);

    @Query(value = "select * from shop order by create_date desc limit ?1, ?2", nativeQuery = true)
    List<Shop> findNewest(Integer offset, Integer limit);
}
