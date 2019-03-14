package com.example.nutritionVendors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;
    private Integer shopitem_id;

    public Favorites() {
    }

    public Favorites(Integer user_id, Integer shopitem_id) {
        this.user_id = user_id;
        this.shopitem_id = shopitem_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getShopitem_id() {
        return shopitem_id;
    }

    public void setShopitem_id(Integer shopitem_id) {
        this.shopitem_id = shopitem_id;
    }
}
