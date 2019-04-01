package com.example.nutritionVendors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "shopitem", schema = "public")
//@Table(name = "shopitem") //, schema = "public")
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Integer status;
    private Double rating;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
//    @JsonIgnore
    private Shop shop;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @JsonIgnore
    private Item item;

    @OneToMany(mappedBy = "shopItem", fetch = FetchType.LAZY)
    private List<Document> documents;

    @OneToMany(mappedBy = "shopItem", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "shopItem", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public ShopItem() {
    }

//    public ShopItem(Integer price, Integer status, Double rating, Shop shop, Item item, List<Document> documents, List<Favorites> favorites, List<Comment> comments) {
//        this.price = price;
//        this.status = status;
//        this.rating = rating;
//        this.shop = shop;
//        this.item = item;
//        this.documents = documents;
//        this.favorites = favorites;
//        this.comments = comments;
//    }


    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Collection<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
