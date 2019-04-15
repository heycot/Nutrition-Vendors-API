package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.EntitiesDTO.CommentDTO;
import com.example.nutritionVendors.entities.Comment;
import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.entities.ShopItem;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.services.CommentService;
import com.example.nutritionVendors.services.ShopItemService;
import com.example.nutritionVendors.services.ShopService;
import com.example.nutritionVendors.services.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(CommentController.BASE_URL)
public class CommentController {
    public final static String BASE_URL = "/api/comment";

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private ShopService shopService;


    @PostMapping("/add")
    public ResponseEntity addNewComment(@RequestHeader(value = "Authorization") String authorizationHeader, @RequestBody CommentDTO commentDTO) throws InternalError {
        try {

            if (authorizationHeader == null || authorizationHeader == "") {

                throw  new InternalException("Wrong authorization ");

            } else {
                User user = userService.findByToken(authorizationHeader);

                Comment comment = new Comment();

                Date date= new Date();
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);

                ShopItem shopItem = shopItemService.getOne(commentDTO.getShopitem_id());
                if (shopItem == null ){
                    throw  new InternalException("do not have that shopitem");
                }

                comment.setShopItem(shopItem);
                comment.setUser(user);
                comment.setId(0);
                comment.setContent(commentDTO.getContent());
                comment.setTitle(commentDTO.getTitle());
                comment.setCreate_date(ts);
                comment.setRating(commentDTO.getRating());
                comment.setStatus(1);
                comment.setUpdate_date(ts);

                Integer number_comment = shopItem.getComments().size();
                Double rating = (shopItem.getRating() * number_comment + comment.getRating() ) / (number_comment + 1);
                shopItem.setRating(rating);
                shopItem.setComment_number(shopItem.getComment_number() + 1);

//                shopService.updateStatusWhenCommented(shopItem);


                return ResponseEntity.ok(commentService.addOne(comment));
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
            throw  new InternalException("internal exception error");
        }

    }

    @GetMapping("/count/{id}")
    public ResponseEntity countNumberComment(@PathVariable(name = "id") Integer shopitem_id) throws InternalError {
        try {

            return ResponseEntity.ok(commentService.countNumberCommentByShopItem(shopitem_id));

        } catch (Exception e) {
            System.out.println(e.getCause());
            throw  new InternalException("internal exception error");
        }

    }

    @GetMapping("/shopitem/{id}/{offset}")
    public ResponseEntity getCommentsByShopId(@PathVariable(name = "id") Integer shopitem_id, @PathVariable(name = "offset") Integer offset) throws InternalError {
        try {

            return ResponseEntity.ok(commentService.getCommentsByShopId(shopitem_id, offset, 5));

        } catch (Exception e) {
            System.out.println(e.getCause());
            throw  new InternalException("internal exception error");
        }

    }

    @GetMapping("/check/shopitem/{id}")
    public ResponseEntity getCommentsByShopIdAnd(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "id") Integer shopitem_id) throws InternalError {
        try {
            if (authorizationHeader == null || authorizationHeader == "") {

                throw  new InternalException("Wrong authorization ");

            } else {
                User user = userService.findByToken(authorizationHeader);
                Comment comment = new Comment();
                comment = commentService.getCommentByShopItemAndUser(shopitem_id, user.getId());
                return ResponseEntity.ok(comment);
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
            throw  new InternalException("internal exception error");
        }

    }

}
