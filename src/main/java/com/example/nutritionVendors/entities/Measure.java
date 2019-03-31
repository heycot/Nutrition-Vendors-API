package com.example.nutritionVendors.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

//@Data
@Entity
//@Table(name = "measure", schema = "public")
@Table(name = "measure") //, schema = "public")
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sign;

    @OneToMany(mappedBy = "measure", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Item> items;

    public Measure() {
    }

    public Measure(String name, String sign, List<Item> items) {
        this.name = name;
        this.sign = sign;
        this.items = items;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
