package com.example.nutritionVendors.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.nutritionVendors.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    User findByEmailAndPassword(String email, String pass);

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE user u SET u.token = :token WHERE u.id = :id")
//    int saveToken(@Param("token") String token, @Param("id") Integer id);

}
