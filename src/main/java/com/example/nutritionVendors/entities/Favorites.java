package com.example.nutritionVendors.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    private Integer id;
    private Integer user_id;
    private Integer shipItem_id;

    public Favorites(Integer id, Integer user_id, Integer shipItem_id) {
        this.id = id;
        this.user_id = user_id;
        this.shipItem_id = shipItem_id;
    }

    public Favorites() {
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

    public Integer getShipItem_id() {
        return shipItem_id;
    }

    public void setShipItem_id(Integer shipItem_id) {
        this.shipItem_id = shipItem_id;
    }
}
