package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query(value = "SELECT * , ( ACOS( COS( RADIANS( ?1  ) ) " +
            "              * COS( RADIANS( latitude ) )" +
            "              * COS( RADIANS( longitude) - RADIANS( ?2 ) )" +
            "              + SIN( RADIANS( ?1  ) )" +
            "              * SIN( RADIANS( latitude ) ) ) * 6371) AS distance_in_km" +
            "  FROM location " +
            " ORDER BY distance_in_km ASC" +
            " LIMIT 100", nativeQuery = true)
    List<Location> findNearestUserLocation(Double latitude, Double longitude);
}
