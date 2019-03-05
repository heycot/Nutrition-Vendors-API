package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "document")
public class Document {

    @Id
    private Integer id;
    private Integer shopItem_id;
    private String link;

    public Document(Integer id, Integer shopItem_id, String link) {
        this.id = id;
        this.shopItem_id = shopItem_id;
        this.link = link;
    }

    public Document() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopItem_id() {
        return shopItem_id;
    }

    public void setShopItem_id(Integer shopItem_id) {
        this.shopItem_id = shopItem_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
