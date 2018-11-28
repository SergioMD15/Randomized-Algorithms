import algorithms.selection.SelectionAlgorithm;
import algorithms.sorting.Mergesort;
import algorithms.selection.Quickselect;
import algorithms.selection.RandomizedMedian;
import algorithms.sorting.SortingAlgorithm;

import java.util.*;

public class Main {

    private static SortingAlgorithm ms = new Mergesort();
    private static SelectionAlgorithm qs = new Quickselect();
    private static SelectionAlgorithm rm = new RandomizedMedian(ms);
    private static InstanceGenerator ig = new InstanceGenerator();

    private static void printSelection(SelectionAlgorithm algorithm, List<List<Integer>> list){
        long before, after;

        System.out.println("#### " +  algorithm.getName().toUpperCase() +
                            " ALGORITHM for size " + list.get(0).size() + " ####\n");

        before = System.currentTimeMillis();
        for(List<Integer> l : list) {
            algorithm.execute(l);
        }
        after = System.currentTimeMillis();

        System.out.println("Total elapsed time per instance: " + (after - before));
        System.out.println();
    }

    private static void printSorting(SortingAlgorithm algorithm, List<List<Integer>> list){
        long before, after;

        System.out.println("#### " +  algorithm.getName().toUpperCase() +
                            " ALGORITHM for size " + list.get(0).size() + " ####\n");

        before = System.currentTimeMillis();
        for(List<Integer> l : list) {
            algorithm.sort(l);
            median(l);
        }
        after = System.currentTimeMillis();

        System.out.println("Total elapsed time: " + (after - before));
        System.out.println();
    }


    public static void main(String args[]) {

        /*For instances of size 50000*/
        printExecution(50000);

        /*For instances of size 75000*/
        printExecution(75000);

        /*For instances of size 100000*/
        printExecution(100000);

        /*For instances of size 125000*/
        printExecution(125000);

        /*For instances of size 150000*/
        printExecution(150000);

        /*For instances of size 175000*/
        printExecution(175000);

        /*For instances of size 200000*/
        printExecution(200000);

        /*For instances of size 250000*/
        printExecution(250000);

        /*For instances of size 300000*/
        printExecution(300000);

        /*For instances of size 400000*/
        printExecution(400000);

        /*For instances of size 500000*/
        printExecution(500000);


        /*For special instances*/
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> aux;
        for(int i = 0; i<4; i++){
            aux = ig.generateSortedInput(3,100000);
            list.add(aux);
            Collections.reverse(aux);
            list.add(aux);
        }
        list.add(ig.generateZerosList());
        list.add(ig.generateTuplesList());

        printSelection(qs, list);
        printSelection(rm, list);
        printSorting(ms, list);
        System.out.println("---------------------\n");
    }

    /**
     * Function used to compute the exact median from
     * a sorted list. Will be used just for checking.
     * Can be used along with InstanceGenerator method
     * generateSortedInput to save time.
     * @param list The sorted list where the median
     *             will be obtained.
     */
    private static int median(List<Integer> list){
        int median;
        if (list.size() % 2 == 0){
            median = (list.get(list.size()/2) + list.get(list.size()/2 - 1))/2;
        } else{
            median = list.get(list.size()/2);
        }
        return median;
    }

    private static void printExecution(int size){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<30; i++){
            list.add(ig.generateRandomInput(3,size));
        }

        printSelection(qs, list);
        printSelection(rm, list);
        printSorting(ms, list);
        System.out.println("---------------------\n");
    }
}
