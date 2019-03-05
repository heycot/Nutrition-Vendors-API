package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    private Integer id;
    private String name;
    private Integer category_id;

    public Item(Integer id, String name, Integer category_id) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
