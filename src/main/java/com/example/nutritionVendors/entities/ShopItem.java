package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
//@Table(name = "shop_item")
public class ShopItem {

    private Integer id;
    private Integer shop_id;
    private Integer item_id;
    private Integer price;
    private Integer status;
    private Double rating;

    public ShopItem(Integer id, Integer shop_id, Integer item_id, Integer price, Integer status, Double rating) {
        this.id = id;
        this.shop_id = shop_id;
        this.item_id = item_id;
        this.price = price;
        this.status = status;
        this.rating = rating;
    }

    public ShopItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
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
}
