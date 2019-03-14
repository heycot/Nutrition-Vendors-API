package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

//@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public City() {
    }

    public City(String name, List<Area> areas) {
        this.name = name;
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
