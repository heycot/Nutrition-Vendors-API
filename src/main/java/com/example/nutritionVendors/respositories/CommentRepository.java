package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer> {


    @Query(value = "select * from comment where shopitem_id = ?1 order by update_date desc limit ?2, ?3", nativeQuery = true)
    List<Comment> findAllByShopItemId(Integer shopitem_id, Integer offset, Integer limit);

    @Query(value = "select * from comment where shopitem_id = ?1 and user_id = ?2", nativeQuery = true)
    Comment findByShopItemIdAndUserId(Integer shopitem_id, Integer user_id);

    Integer countByShopItemId(Integer shopitem_id);
}
