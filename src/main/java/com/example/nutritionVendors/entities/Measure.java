package com.example.nutritionVendors.entities;


import javax.persistence.*;
import java.util.Collection;

//@Data
@Entity
@Table(name = "measure")
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sign;

    @OneToMany(mappedBy = "measure")
    private Collection<Item> items;

    public Measure() {
    }

    public Measure(Integer id, String name, String sign) {
        this.id = id;
        this.name = name;
        this.sign = sign;
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
}
