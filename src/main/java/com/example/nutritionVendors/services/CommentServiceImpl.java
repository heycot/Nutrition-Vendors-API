package com.example.nutritionVendors.services;

import com.example.nutritionVendors.EntitiesDTO.CommentDTO;
import com.example.nutritionVendors.entities.Comment;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.respositories.CommentRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ShopService shopService;

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

    @Override
    public Comment getOne(Integer id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment edit(Comment comment) {

        Comment commentEdit = commentRepository.findOne(comment.getId());
        commentEdit = updateComment(commentEdit, comment);
        return commentRepository.save(commentEdit);
    }

    public Comment updateComment(Comment commentEdit, Comment comment) {

        commentEdit.setShopItem(comment.getShopItem());
        commentEdit.setUser(comment.getUser());
        commentEdit.setContent(comment.getContent());
        commentEdit.setTitle(comment.getTitle());
        commentEdit.setRating(comment.getRating());
        commentEdit.setStatus(1);
        commentEdit.setUpdate_date(comment.getUpdate_date());


        return comment;
    }
}
