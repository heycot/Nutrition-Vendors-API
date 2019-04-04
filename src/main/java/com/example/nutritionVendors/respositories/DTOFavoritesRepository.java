package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.FavoritesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DTOFavoritesRepository extends JpaRepository<FavoritesDTO, Integer> {

    @Query(value = "select * from favorites where user_id = ?1", nativeQuery = true)
    List<FavoritesDTO> findAllByUser_id(Integer user_id);
}
