package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
//@Table(name = "area")
public class Area {

    @Id
    private Integer id;
    private Integer city_id;
    private String name;

    public Area(Integer id, Integer city_id, String name) {
        this.id = id;
        this.city_id = city_id;
        this.name = name;
    }

    public Area() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
