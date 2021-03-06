package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

//@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user_name;
    private String email;
    private String phone;
    private String password;
    private Timestamp birthday;
    private String address;
    private String avatar;
    private Timestamp create_date;
    private Integer status;

    public User(Integer id, String user_name, String email, String phone, String password, Timestamp birthday, String address, String avatar, Timestamp create_date, Integer status) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.avatar = avatar;
        this.create_date = create_date;
        this.status = status;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
}
