package main.pojos;

import java.util.HashSet;

public class Features {
    private String name;
    private Price price;
    private int stock;
    private boolean availability;
    private HashSet<Picture> pictures;
    private Dimensions dimensions;

    public Features(String name, Price price, int stock, boolean availability, HashSet<Picture> pictures, Dimensions dimensions) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.availability = availability;
        this.pictures = pictures;
        this.dimensions = dimensions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public HashSet<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(HashSet<Picture> pictures) {
        this.pictures = pictures;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
