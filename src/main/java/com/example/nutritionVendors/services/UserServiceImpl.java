package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.UserDTO;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.UserTokenHandle;
import com.example.nutritionVendors.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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

}
