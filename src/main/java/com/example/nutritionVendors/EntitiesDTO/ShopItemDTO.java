package com.example.nutritionVendors.EntitiesDTO;

import com.example.nutritionVendors.entities.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ShopItemDTO {

    private Integer id;
    private Integer price;
    private Integer status;
    private Double rating;
    private Integer comment_number;
    private Integer favorites_number;
    private String name;
    private String category_name;
    private String avatar;


    public ShopItemDTO() {
    }

    public ShopItemDTO(Integer id, Integer price, Integer status, Double rating, Integer comment_number, Integer favorites_number, String name, String category_name, String avatar) {
        this.id = id;
        this.price = price;
        this.status = status;
        this.rating = rating;
        this.comment_number = comment_number;
        this.favorites_number = favorites_number;
        this.name = name;
        this.category_name = category_name;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getComment_number() {
        return comment_number;
    }

    public void setComment_number(Integer comment_number) {
        this.comment_number = comment_number;
    }

    public Integer getFavorites_number() {
        return favorites_number;
    }

    public void setFavorites_number(Integer favorites_number) {
        this.favorites_number = favorites_number;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
