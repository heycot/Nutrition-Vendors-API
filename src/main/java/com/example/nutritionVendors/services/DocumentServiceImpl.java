package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Document;
import com.example.nutritionVendors.respositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

//    @Override
//    public List<Document> findAllByShopItemId( id) {
//        return documentRepository.findAllByShopItemId(id);
//    }
}
