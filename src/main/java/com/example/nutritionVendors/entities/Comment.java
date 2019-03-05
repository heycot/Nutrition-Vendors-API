package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    private Integer id;
    private Integer user_id;
    private Integer shopItem_id;
    private String content;
    private Integer rating;
    private Timestamp create_date;
    private  Integer status;

    public Comment(Integer id, Integer user_id, Integer shopItem_id, String content, Integer rating, Timestamp create_date, Integer status) {
        this.id = id;
        this.user_id = user_id;
        this.shopItem_id = shopItem_id;
        this.content = content;
        this.rating = rating;
        this.create_date = create_date;
        this.status = status;
    }

    public Comment() {
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

    public Integer getShopItem_id() {
        return shopItem_id;
    }

    public void setShopItem_id(Integer shopItem_id) {
        this.shopItem_id = shopItem_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
