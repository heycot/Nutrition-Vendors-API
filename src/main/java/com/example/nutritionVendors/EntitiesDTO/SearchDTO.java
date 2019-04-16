package com.example.nutritionVendors.EntitiesDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SearchDTO {

    @Id
    private Integer id;
    private Integer entity_id;
    private String entity_name;
    private Integer comment_number;
    private Double rating;
    private String address;
    private Integer is_shop;
    private String avatar;

    public SearchDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIs_shop() {
        return is_shop;
    }

    public void setIs_shop(Integer is_shop) {
        this.is_shop = is_shop;
    }

    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public Integer getComment_number() {
        return comment_number;
    }

    public void setComment_number(Integer comment_number) {
        this.comment_number = comment_number;
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
//
//    public Boolean getShop() {
//        return isShop;
//    }
//
//    public void setShop(Boolean shop) {
//        isShop = shop;
//    }
//
//    public String getDistance() {
//        return distance;
//    }
//
//    public void setDistance(String distance) {
//        this.distance = distance;
//    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
