package com.example.nutritionVendors.EntitiesDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SearchDTO {

    @Id
    private Integer id;
    private Integer shopitem_id;
    private String shopitem_name;
    private Integer shop_id;
    private String shop_name;
    private Integer number_comment;
    private Double rating;
    private String address;
    private Boolean isShop;
    private String distance;
    private String avatar;

    public SearchDTO() {
    }

    public Integer getShopitem_id() {
        return shopitem_id;
    }

    public void setShopitem_id(Integer shopitem_id) {
        this.shopitem_id = shopitem_id;
    }

    public String getShopitem_name() {
        return shopitem_name;
    }

    public void setShopitem_name(String shopitem_name) {
        this.shopitem_name = shopitem_name;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Integer getNumber_comment() {
        return number_comment;
    }

    public void setNumber_comment(Integer number_comment) {
        this.number_comment = number_comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getShop() {
        return isShop;
    }

    public void setShop(Boolean shop) {
        isShop = shop;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
