package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer> {

    Integer countByShopItemId(Integer id);
}
