package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOneByNameAndPassword(User user) {
        return userRepository.findOneByNameAndPassword(user.getUser_name(), user.getPassword());
    }

    @Override
    public User findOneById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
