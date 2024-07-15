package resources.tests;

import main.pojos.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmsTests {

    public static void main(String args[]){
        AlgorithmsTests tests = new AlgorithmsTests();
        //sorted list with a range of numbers from 0 to 10,000
        List<Integer> sortedList = IntStream.rangeClosed(0, 10_000).boxed().collect(Collectors.toList());
        //unsorted list with a big amount of numbers


        /*long start2 = System.nanoTime();
        tests.insertionSort(sortedList, 0, sortedList.size()-1);
        long end2 = System.nanoTime();
        System.out.println("InsertionSort execution: " + Long.toString(end2-start2));

        long start3 = System.nanoTime();
        tests.optimizedQuickSort(sortedList, 0, sortedList.size()-1);
        long end3 = System.nanoTime();
        System.out.println("Optimized quickSort execution: " + Long.toString(end3-start3));*/
        try{
            System.out.println("--------------------------Testing over a sorted list------------------------");
            long start1 = System.nanoTime();
            tests.quickSort(sortedList, 0, sortedList.size()-1);
            long end1 = System.nanoTime();
            System.out.println("QuickSort execution: (nano sec.)" + Long.toString(end1-start1));
            /*long start2 = System.nanoTime();
            tests.quickSort2(sortedList, 0, sortedList.size()-1);
            long end2 = System.nanoTime();
            System.out.println("QuickSort2 execution: (nano sec.)" + Long.toString(end2-start2));*/
            long start3 = System.nanoTime();
            tests.insertionSort(sortedList, 0, sortedList.size()-1);
            long end3 = System.nanoTime();
            System.out.println("InsertionSort execution: (nano sec.)" + Long.toString(end3-start3));
            long start4 = System.nanoTime();
            tests.optimizedQuickSort(sortedList, 0, sortedList.size()-1);
            long end4 = System.nanoTime();
            System.out.println("Optimized QuickSort execution: (nano sec.)" + Long.toString(end4-start4));
            System.out.println();

            System.out.println("--------------------------Testing over a shuffled list------------------------");
            Collections.shuffle(sortedList);
            long start5 = System.nanoTime();
            tests.quickSort(sortedList, 0, sortedList.size()-1);
            long end5 = System.nanoTime();
            System.out.println("QuickSort execution: (nano sec.)" + Long.toString(end5-start5));
            Collections.shuffle(sortedList);
            long start6 = System.nanoTime();
            tests.insertionSort(sortedList, 0, sortedList.size()-1);
            long end6 = System.nanoTime();
            System.out.println("InsertionSort execution: (nano sec.)" + Long.toString(end6-start6));
            Collections.shuffle(sortedList);
            long start7 = System.nanoTime();
            tests.optimizedQuickSort(sortedList, 0, sortedList.size()-1);
            long end7 = System.nanoTime();
            System.out.println("Optimized QuickSort execution: (nano sec.)" + Long.toString(end7-start7));


        }catch(StackOverflowError e){
            System.out.println(e.getStackTrace());
        }

        /*Random rm = new Random();
        List<Integer> arr = IntStream.rangeClosed(0, 1_000).boxed().collect(Collectors.toList());
        int i = 1;
        int num = 0;
        try{
            while(i < 1_000) {
                num = rm.nextInt(-10_000, 10_000);
                //Collections.shuffle(arr);
                int result = tests.binarySearch(arr, 0, arr.size()-1, num);
                System.out.println("test " + Integer.toString(i) + " passed for number " + Integer.toString(num) + " result : " + Integer.toString(result));
                i++;
            }
        }catch(Exception e) {

            System.out.println("test " + Integer.toString(i) + " failed for number " + Integer.toString(num));
        }*/
    }
    public int  binarySearch(List<Integer> arr, int start, int end, int x){
        if(end > start){
            int pivot = start + (int) (end - start)/2;

            if(arr.get(pivot) == x){
                return arr.get(pivot);
            } else if (arr.get(pivot) < x) {
                return binarySearch(arr, pivot+1, end, x);
            } else if (arr.get(pivot) > x) {
                return binarySearch(arr, start, pivot-1, x);
            }
        }
        return arr.get(start) == x ? arr.get(start) : -1;

    }

    public int  partition(List<Integer> arr, int i, int j){
        // i= low, j = high
        int pivot = arr.get(i);
        int pivotIdx = j;

        for (int tj = j; tj > i; tj --){
            if(arr.get(tj) > pivot){
                swap(arr, tj, pivotIdx--);
            }
        }
        swap(arr, i, pivotIdx);

        return pivotIdx;

    }

    public void swap(List<Integer> arr, int i, int j){
        int copy = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, copy);
    }

    public void quickSort(List<Integer> arr, int i, int j){
        if(i < j){
            int tj = partition(arr, i, j);
            quickSort(arr, i, tj-1);
            quickSort(arr, tj+1, j);
        }
    }

    public void optimizedQuickSort(List<Integer> arr, int i, int j){
        if(j-i > 15){
            int tj = partition(arr, i, j);
            quickSort(arr, i, tj-1);
            quickSort(arr, tj+1, i);
        }
        insertionSort(arr, i, j);
    }

    public void insertionSort(List<Integer> arr, int i, int j){
        int key;
        int y;

        for(int z= i+1; z<= j; z++){
            key = arr.get(z);
            y= z-1;

            while (y >= 0 && arr.get(y) > key){
                arr.set(y+1, arr.get(y));
                y--;
            }

            arr.set(y+1, key);
        }
    }

    public void quickSort2(List<Integer> arr, int i, int j) {
        if (j > i) {
            int pivot = arr.get(i);
            int ti = i;
            int tj = j;

            while (tj > ti) {
                if (arr.get(ti) > pivot && arr.get(tj) <= pivot) {
                    swap(arr, ti, tj);
                }
                while (ti < j && arr.get(ti) <= pivot) {
                    ti++;
                }
                while (arr.get(tj) > pivot) {
                    tj--;
                }
            }
            arr.set(i, arr.get(tj));
            arr.set(tj, pivot);

            quickSort(arr, i, tj - 1);
            quickSort(arr, tj + 1, j);
        }
    }

    /*public void optimizedQuickSort2(List<Integer> arr, int i, int j){
       if(j-i > 15){
           int pivot = arr.get(i);
           int ti = i;
           int tj = j;

           while(tj > ti){
               if(arr.get(ti) > pivot  && arr.get(tj) <= pivot){
                   swap(arr, ti, tj);
               }
               while(ti < j && arr.get(ti) <= pivot){
                   ti++;
               }
               while(arr.get(tj) > pivot){
                   tj--;
               }
           }
           arr.set(i, arr.get(tj));
           arr.set(tj, pivot);

           quickSort(arr, i, tj-1);
           quickSort(arr, tj+1, j);
       }

       insertionSort(arr, i, j);

    }*/

}
