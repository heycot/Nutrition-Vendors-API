package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
//@Table(name = "shop")
public class Shop {

    @Id
    private Integer id;
    private Integer location_id;
    private String name;
    private Double rating;
    private Timestamp time_open;
    private Timestamp time_close;
    private Timestamp create_date;
    private Integer status;
    private String phone;
    private String avatar;

    public Shop(Integer id, Integer location_id, String name, Double rating, Timestamp time_open, Timestamp time_close, Timestamp create_date, Integer status, String phone, String avatar) {
        this.id = id;
        this.location_id = location_id;
        this.name = name;
        this.rating = rating;
        this.time_open = time_open;
        this.time_close = time_close;
        this.create_date = create_date;
        this.status = status;
        this.phone = phone;
        this.avatar = avatar;
    }

    public Shop() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Timestamp getTime_open() {
        return time_open;
    }

    public void setTime_open(Timestamp time_open) {
        this.time_open = time_open;
    }

    public Timestamp getTime_close() {
        return time_close;
    }

    public void setTime_close(Timestamp time_close) {
        this.time_close = time_close;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
