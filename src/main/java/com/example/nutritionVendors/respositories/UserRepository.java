package com.example.nutritionVendors.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.nutritionVendors.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    User findByEmailAndPassword(String email, String pass);

    User findByToken(String token);

}
