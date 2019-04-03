package com.example.nutritionVendors.EntitiesDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class ShopItemDTO {

    @Id
    private Integer id;
    private Double price;
    private Integer status;
    private Double rating;
    private Integer comment_number;
    private Integer favorites_number;
    private String name;
    private String shop_name;
    private String avatar;
    private Integer love_status;



    public ShopItemDTO() {
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public void setComment_number(Integer comment_number) {
        this.comment_number = comment_number;
    }

    public void setFavorites_number(Integer favorites_number) {
        this.favorites_number = favorites_number;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Integer getFavorites_number() {
        return favorites_number;
    }

    public Integer getLove_status() {
        return love_status;
    }

    public void setLove_status(Integer love_status) {
        this.love_status = love_status;
    }
}
