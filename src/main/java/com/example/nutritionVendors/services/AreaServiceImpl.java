package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Area;
import com.example.nutritionVendors.respositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }
}
