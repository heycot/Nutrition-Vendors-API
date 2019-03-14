package com.example.nutritionVendors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer category_id;
    private Integer measure_id;

    public Item() {
    }

    public Item(String name, Integer category_id, Integer measure_id) {
        this.name = name;
        this.category_id = category_id;
        this.measure_id = measure_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(Integer measure_id) {
        this.measure_id = measure_id;
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

}
