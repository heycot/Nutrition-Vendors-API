package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Comment;
import com.example.nutritionVendors.respositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addOne(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByShopId(Integer shopitem_id, Integer offset, Integer limit) {
        return commentRepository.findAllByShopItemId(shopitem_id, offset, limit);
    }

    @Override
    public Comment getCommentByShopItemAndUser(Integer shopitem_id, Integer id) {
        return commentRepository.findByShopItemIdAndUserId(shopitem_id, id);
    }

    @Override
    public Integer countNumberCommentByShopItem(Integer shopitem_id) {
        return commentRepository.countByShopItemId(shopitem_id);
    }
}
