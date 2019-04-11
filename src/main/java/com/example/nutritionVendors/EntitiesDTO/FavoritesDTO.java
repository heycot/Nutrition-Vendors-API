package com.example.nutritionVendors.EntitiesDTO;

import com.example.nutritionVendors.entities.ShopItem;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class FavoritesDTO {

    @Id
    private Integer id;
    private Integer shopitem_id;
    private Integer user_id;
    private Integer status;
    private Timestamp create_date;
    private Timestamp update_date;

    public FavoritesDTO() {
    }

    public FavoritesDTO(Integer id, Integer shopitem_id, Integer user_id, Integer status, Timestamp create_date, Timestamp update_date) {
        this.id = id;
        this.shopitem_id = shopitem_id;
        this.user_id = user_id;
        this.status = status;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
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
