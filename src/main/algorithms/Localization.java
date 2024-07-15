package main.algorithms;

import java.util.Optional;

public class Localization {
    /*public static void main (String[] args){
        int[] arr = new int[]{0, 1,2,3,4,5};
        //int idx = (int) arr.length/2;
        System.out.println(binarySearch(arr, 0, arr.length-1, 0));

    }*/

    public int  binarySearch(int[] arr, int start, int end, int x){
        if(end > start){
            int pivot = start + (int) (end - start)/2;

            if(arr[pivot] == x){
                return arr[pivot];
            } else if (arr[pivot] < x) {
                return binarySearch(arr, pivot+1, end, x);
            } else if (arr[pivot] > x) {
                return binarySearch(arr, start, pivot-1, x);
            }
        }
        return arr[start] == x ? arr[end] : -1;

    }
}
