package com.example.nutritionVendors.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String storeFile(MultipartFile file);
}
