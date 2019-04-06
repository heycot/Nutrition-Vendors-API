package com.example.nutritionVendors.services;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

//    private final Path fileStorageLocation;


    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new InternalError("Sorry! Filename contains invalid path sequence " + fileName);
            }

//            // Copy file to the target location (Replacing existing file with the same name)
//            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//            System.out.println("hihihihihi");
//            System.out.println(targetLocation);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            System.out.println();
            String path = "images" + "/" + fileName;
            System.out.println("Copying file " + new File(path));
            FileCopyUtils.copy(file.getBytes(), new File(path));
            return fileName;
        } catch (IOException ex) {
            throw new InternalError("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public void deleteFile(String fileName) {
//        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
//        System.out.println(fileName);
//        Path targetLocation = fileStorageLocation.resolve(fileName);
//        System.out.println(targetLocation.toString());
//        try {
//            Files.delete(targetLocation);
//            System.out.println("Yeah");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }

//    public Resource loadFileAsResource(String fileName) {
//        try {
//            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
//            System.out.println("==============================================================");
//            System.out.println(filePath);
//            System.out.println(filePath.toUri());
//            Resource resource = new UrlResource(filePath.toUri());
//            System.out.println(resource);
//            System.out.println("=========================================");
//            if(resource.exists()) {
//                return resource;
//            } else {
//                throw new MyFileNotFoundException("File not found " + fileName);
//            }
//        } catch (MalformedURLException ex) {
//            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//            System.out.println(ex.getMessage());
//            throw new MyFileNotFoundException("File not found " + fileName, ex);
//        }
//    }
}
