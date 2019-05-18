package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Item;
import com.example.nutritionVendors.respositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getall() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getById(Integer id) {
        return itemRepository.findAllByCategoryId(id);
    }
}
