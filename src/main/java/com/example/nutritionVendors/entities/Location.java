package com.example.nutritionVendors.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
//@Table(name = "location")
public class Location {

    @Id
    private Integer id;
    private Integer area_id;
    private String name;
    private String address;
    private Double longitude;
    private Double latitude;

    public Location(Integer id, Integer area_id, String name, String address, Double longitude, Double latitude) {
        this.id = id;
        this.area_id = area_id;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
