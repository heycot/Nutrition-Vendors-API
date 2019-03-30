package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

//@Data
@Entity
@Table(name = "city", schema = "public")
//@Table(name = "city") //, schema = "public")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Area> areas;

    public City() {
    }

    public City(String name, List<Area> areas) {
        this.name = name;
        this.areas = areas;
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

    public Collection<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
