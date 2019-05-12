package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.UserTokenHandle;
import com.example.nutritionVendors.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileService fileService;

    private UserTokenHandle userTokenHandle = new UserTokenHandle();

    @Override
    public User findOneByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user != null ) {
            user.setToken(userTokenHandle.generateUserToken(user.getId()));
            userRepository.save(user);
        }

        return user;
    }

    @Override
    public User findOneById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User signUp(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getOneById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByToken(String authorizationHeader) {
        return userRepository.findByToken(authorizationHeader);
    }

    @Override
    public Integer saveImage(MultipartFile file) {
        try {

            if(file != null ) {
                String fileName = fileService.storeFile(file);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                                    .path("/api/images/")
                                                                    .path(fileName)
                                                                    .toUriString();

                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println("eror image");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public User findByTokenAndPassword(String authorizationHeader, String pass) {
        return userRepository.findByTokenAndPassword(authorizationHeader, pass);
    }

    @Override
    public Integer changePass(String authorizationHeader, String pass) {
        User user = userRepository.findByToken(authorizationHeader);

        if ( user != null ) {
            user.setPassword(pass);
            userRepository.save(user);
            return 1;
        }

        return 0;
    }


    @Override
    public User editInfor(String authorizationHeader, User user, String dateStr) {
        User userEdit = userRepository.findByToken(authorizationHeader);

        if ( userEdit == null ) {
            return null;
        }  else {

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(dateStr);
                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

                userEdit.setName(user.getName());
                userEdit.setPhone(user.getPhone());
                userEdit.setBirthday(timestamp);
                userEdit.setAddress(user.getAddress());

                userRepository.save(userEdit);

            } catch(Exception e) { //this generic but you can control another types of exception
                // look the origin of excption
            }
        }

        return userEdit;
    }

}
