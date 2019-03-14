package com.example.nutritionVendors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String link;
    private Integer shopitem_id;

    public Document() {
    }

    public Document(String link, Integer shopitem_id) {
        this.link = link;
        this.shopitem_id = shopitem_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getShopitem_id() {
        return shopitem_id;
    }

    public void setShopitem_id(Integer shopitem_id) {
        this.shopitem_id = shopitem_id;
    }
}
