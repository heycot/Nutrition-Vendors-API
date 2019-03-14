package com.example.nutritionVendors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

//@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Integer rating;
    private Timestamp create_date;
    private  Integer status;
    private Integer user_id;
    private Integer shopitem_id;

    public Comment() {
    }

    public Comment(String title, String content, Integer rating, Timestamp create_date, Integer status, Integer user_id, Integer shopitem_id) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.create_date = create_date;
        this.status = status;
        this.user_id = user_id;
        this.shopitem_id = shopitem_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
