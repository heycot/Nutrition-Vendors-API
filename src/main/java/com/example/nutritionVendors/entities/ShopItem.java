package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shopitem")
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;
    private Integer status;
    private Double rating;
    private Integer item_id;
    private Integer shop_id;

    public ShopItem() {
    }

    public ShopItem(Integer price, Integer status, Double rating, Integer item_id, Integer shop_id) {
        this.price = price;
        this.status = status;
        this.rating = rating;
        this.item_id = item_id;
        this.shop_id = shop_id;
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

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }
}
