package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
//@Table(name = "comment")
public class Comment {

    private Integer id;
    private Integer user_id;
    private Integer shop_id;
    private Integer father_id;
    private String content;
    private Integer rating;
    private Timestamp create_date;
    private  Integer status;

    public Comment(Integer id, Integer user_id, Integer shop_id, Integer father_id, String content, Integer rating, Timestamp create_date, Integer status) {
        this.id = id;
        this.user_id = user_id;
        this.shop_id = shop_id;
        this.father_id = father_id;
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

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getFather_id() {
        return father_id;
    }

    public void setFather_id(Integer father_id) {
        this.father_id = father_id;
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
