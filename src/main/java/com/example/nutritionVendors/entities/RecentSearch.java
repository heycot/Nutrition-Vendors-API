package com.example.nutritionVendors.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "recent_search")
public class RecentSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer entity_id;
    private Integer is_shop;
    private Timestamp create_date;
    private Timestamp update_date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public RecentSearch() {
    }

    public RecentSearch(Integer entity_id, Integer is_shop, Timestamp create_date, Timestamp update_date, User user) {
        this.entity_id = entity_id;
        this.is_shop = is_shop;
        this.create_date = create_date;
        this.update_date = update_date;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }


    public Integer getIs_shop() {
        return is_shop;
    }

    public void setIs_shop(Integer is_shop) {
        this.is_shop = is_shop;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}