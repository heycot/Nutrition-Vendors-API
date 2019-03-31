package com.example.nutritionVendors.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.nutritionVendors.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    @Query(value = "SELECT * FROM public.user WHERE user_name LIKE ?1 and password LIKE ?2", nativeQuery = true)
    User findOneByNameAndPassword(String userName, String pass);

}
