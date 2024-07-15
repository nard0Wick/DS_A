package main.algorithms;

import com.google.gson.Gson;
import main.pojos.Product;
import main.repo.ProductsRepo;

import java.util.*;

public class Sorting {
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

        Sorting sorting = new Sorting();
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
        products = productsRepo.getProducts();

        sorting.optimizedQuickSort(products, 0, products.size()-1);

        for(Product p : products){
            System.out.println(p.getFeatures().getName());
        }

        /*System.out.println(search.parseNum("Product1"));*/

    }

    public int  partition(List<Product> arr, int i, int j){
        // i= low, j = high
        int pivot = parseNum(arr.get(i).getFeatures().getName());
        int pivotIdx = j;

        for (int tj = j; tj > i; tj --){
            if(parseNum(arr.get(tj).getFeatures().getName()) > pivot){
                swap(arr, tj, pivotIdx--);
            }
        }
        swap(arr, i, pivotIdx);

        return pivotIdx;

    }

    public void swap(List<Product> arr, int i, int j){
        Product product = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, product);
    }

    public void quickSort(List<Product> arr, int i, int j){
        /**
         * Quick sort algorithm has an average complexity of nlog n, is considered as one of the most
         * effective and optimized algorithms for sorting, however the way data is processed may increase
         * complexity for specific cases, most of them sharing in common an almost sorted arrange of numbers.
         */
        if(i < j){

            int tj = partition(arr, i, j);

            quickSort(arr, i, tj-1);
            quickSort(arr, tj+1, j);
        }

    }

    public void optimizedQuickSort(List<Product> arr, int i, int j){
        if(j-i > 15){
            int tj = partition(arr, i, j);

            quickSort(arr, i, tj-1);
            quickSort(arr, tj+1, j);
        }
        insertionSort(arr, i, j);
    }

    public void insertionSort(List<Product> arr, int i, int j){
        Product key;
        int y;
        for(int z = i+1; z <= j; z++){
            key = arr.get(z);
            y = z-1;

            while(y >= 0 &&
                    parseNum(arr.get(y).getFeatures().getName()) > parseNum(key.getFeatures().getName())){
                arr.set(y+1, arr.get(y));
                y--;
            }

            arr.set(y+1, key);
        }

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
