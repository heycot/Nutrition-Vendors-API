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
    private BigInteger comment_number;
    private BigInteger favorites_number;
    private String name;
    private String avatar;



    public ShopItemDTO() {
    }

    public void setComment_number(BigInteger comment_number) {
        this.comment_number = comment_number;
    }

    public void setFavorites_number(BigInteger favorites_number) {
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

    public BigInteger getComment_number() {
        return comment_number;
    }

    public BigInteger getFavorites_number() {
        return favorites_number;
    }
}
