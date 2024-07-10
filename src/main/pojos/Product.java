package main.pojos;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Product {
    private ObjectId id;
    private Long vendorId;
    private Features features;
    private ArrayList<Categories> categories;
    //private HashMap<String, Comments> comments;
    private HashMap<String, Comments> comments;

    public Product(ObjectId id, Long vendorId, Features features, ArrayList<Categories> categories, HashMap<String, Comments> comments) {
        this.id = id;
        this.vendorId = vendorId;
        this.features = features;
        this.categories = categories;
        this.comments = comments;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    public HashMap<String, Comments> getComments() {
        return comments;
    }

    public void setComments(HashMap<String, Comments> comments) {
        this.comments = comments;
    }
}
