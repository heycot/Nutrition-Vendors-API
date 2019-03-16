package com.example.nutritionVendors.EntitiesDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class ShopItemDTO {

    @Id
    private Integer id;
    private Double price;
    private Integer status;
    private Double rating;
    private BigInteger comment_number;
    private BigInteger favorites_number;
    private String name;
    private String avatar;

//    private List<Document> documents;


    public ShopItemDTO() {
    }

    //
//    public ShopItemDTO(Integer id, Double price, Integer status, Double rating, Integer comment_number, Integer favorites_number, String name) {
//        this.id = id;
//        this.price = price;
//        this.status = status;
//        this.rating = rating;
//        this.comment_number = comment_number;
//        this.favorites_number = favorites_number;
//        this.name = name;
//    }
//


    public void setComment_number(BigInteger comment_number) {
        this.comment_number = comment_number;
    }

    public void setFavorites_number(BigInteger favorites_number) {
        this.favorites_number = favorites_number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Document> getDocuments() {
//        return documents;
//    }
//
//    public void setDocuments(List<Document> documents) {
//        this.documents = documents;
//    }
}
