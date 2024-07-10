package main.repo;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import main.pojos.Product;
import org.bson.Document;
import resources.MongoDb;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepo {

    private MongoCollection<Document> productsCollection;
    private List<Product> products = null;
    private Gson gson = new Gson();

    public ProductsRepo(){
        try{
            MongoDb.loadDb();
            productsCollection = MongoDb.getMongoClient()
                    .getDatabase("ecommerce")
                    .getCollection("products");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<Product> getProducts() {
        products = new ArrayList<>();
        productsCollection.find()
                .forEach(document -> products.add(gson.fromJson(document.toJson(), Product.class)));
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public MongoCollection<Document> getProductsCollection() {
        return productsCollection;
    }

    /*private MongoCollection<Document> productsCollection;
    private static ArrayList<Product> products;
    private Gson gson = new Gson();

    public ProductsRepo(){
        if(MongoDb.loadDb()){
            productsCollection = MongoDb.getMongoDatabase().getCollection("products");
            productsCollection.find()
                    .forEach(p -> products.add(gson.fromJson(p.toJson(), Product.class)));
            MongoDb.closeConnection();
        }else{
            System.out.println("Couldn't connect to database");
        }
    }
    //maybe a CRUD here!!!


    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        ProductsRepo.products = products;
    }*/
}
