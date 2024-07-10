package main.algorithms;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import main.pojos.Product;
import main.repo.ProductsRepo;
import org.bson.Document;
import resources.MongoDb;

import java.util.*;

public class Search {
    private static ProductsRepo productsRepo = new ProductsRepo();
    private static List<Product> products;
    private Gson gson = new Gson();

    public static void main(String args[]){
        /*ArrayList<String> words = new ArrayList<>();
        words.add("lettuce");
        words.add("peppers");
        words.add("cucumbers");
        words.add("onions");
        words.add("apples");
        Search search = new Search();
        search.quick(words);*/

        Search search = new Search();
        /*search.quickSort(new int[]{2,5,6,10,1,0});*/
        /*List<Integer> a = new ArrayList<>();
        Scanner sc  = new Scanner(System.in);
        for(int i = 0; i < 12; i++){
            a.add(sc.nextInt());
        }

        for(int i : search.insertionSort(a)){
            System.out.print(i + " ");
        }*/

        /*for(char c: "123".toCharArray()){
            int ascii;
            ascii = c;
            System.out.println(c + " " + ascii);
        }*/

        products = search.insertionSort(productsRepo.getProducts());

        for(Product p : products){
            System.out.println(p.getFeatures().getName());
        }

        /*System.out.println(search.parseNum("Product1"));*/

    }

    public  void test(){
        products = productsRepo.getProducts();
        for(Product product: products){
            System.out.println(product.getFeatures().getName());
        }
    }

    public void quick(ArrayList<String> words){

    }

    public void quickSort(int[] array){
        int pivot = array[(int)array.length/2]; //10
        
    }

    public List<Product> insertionSort(List<Product> arr){
        Product key;
        int j;
        for(int i = 1; i < arr.size(); i++){
            key = arr.get(i);
            j = i -1;

            while(j >= 0 &&
                    parseNum(arr.get(j).getFeatures().getName()) > parseNum(key.getFeatures().getName())){
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j+1, key);
        }

        return arr;
    }

    public int parseNum(String word){

        int asciiTotal = 0;
        for(char c :word.toLowerCase().toCharArray()){
            if(c != ' '){
                asciiTotal += c;
            }
        }

        return asciiTotal;
    }
}
