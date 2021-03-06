package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

//@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "city")
    private Collection<Area> areas;

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public City() {
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
