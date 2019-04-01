package com.example.nutritionVendors.services;

import com.example.nutritionVendors.entities.Comment;
import com.example.nutritionVendors.respositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addOne(Comment comment) {
        return commentRepository.save(comment);
    }
}
