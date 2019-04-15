package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addOne(Comment comment);

    List<Comment> getCommentsByShopId(Integer shopitem_id, Integer offset, Integer limit);

    Comment getCommentByShopItemAndUser(Integer shopitem_id, Integer id);


    Integer countNumberCommentByShopItem(Integer shopitem_id);
}
