package com.example.nutritionVendors.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

//@Data
@Entity
@Table(name = "category", schema = "public")
//@Table(name = "category") //, schema = "public")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Item> items;

    public Category(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Category() {
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

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
