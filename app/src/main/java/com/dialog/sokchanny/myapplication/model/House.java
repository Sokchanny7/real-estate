package com.dialog.sokchanny.myapplication.model;

/**
 * Created by sokchanny on 3/28/17.
 */

public class House {
    private int     id;
    private float   price;
    private String  description;
    private String  location;
    private int[]   images;

    public House(int id, float price, String description, String location) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.location = location;
    }

    public House(int id, float price, String description, String location,int[] images) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.location = location;
        this.images = images;
    }

    public House() {
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
