package com.example.nutritionVendors.EntitiesDTO;

import com.example.nutritionVendors.entities.ShopItem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavoritesDTO {

    @Id
    private Integer id;
    private Integer shopitem_id;
    private Integer user_id;
    private Integer status;

    public FavoritesDTO() {
    }

    public FavoritesDTO(Integer id, Integer shopitem_id, Integer user_id, Integer status) {
        this.id = id;
        this.shopitem_id = shopitem_id;
        this.user_id = user_id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopitem_id() {
        return shopitem_id;
    }

    public void setShopitem_id(Integer shopitem_id) {
        this.shopitem_id = shopitem_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
