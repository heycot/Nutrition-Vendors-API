package com.example.nutritionVendors.respositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nutritionVendors.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
