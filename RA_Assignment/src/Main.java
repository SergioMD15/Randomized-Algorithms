import algorithms.selection.SelectionAlgorithm;
import algorithms.sorting.Mergesort;
import algorithms.selection.Quickselect;
import algorithms.selection.RandomizedMedian;
import algorithms.sorting.SortingAlgorithm;

import java.util.List;

public class Main {

    /**
     * Useful function to print the a list.
     * @param list The list to be printed.
     */
    private static void printList(List<Integer> list) {
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void printSelection(SelectionAlgorithm algorithm, List<Integer> list){
        int result;
        long before, after;

        System.out.println("#### " +  algorithm.getName().toUpperCase() + " ALGORITHM ####\n");

        before = System.currentTimeMillis();
        result = algorithm.execute(list);
        after = System.currentTimeMillis();

        System.out.println("Calculated value of the median: " + result);
        System.out.println("Total elapsed time: " + (after - before));
        System.out.println();
    }

    private static void printSorting(SortingAlgorithm algorithm, List<Integer> list){
        int median;
        long before, after;

        System.out.println("#### " +  algorithm.getName().toUpperCase() + " ALGORITHM ####\n");

        before = System.currentTimeMillis();
        algorithm.sort(list);
        median = median(list);
        after = System.currentTimeMillis();

        //System.out.println("Sorted list:");
        //printList(list);
        System.out.println("Real median of the array:" + median);
        System.out.println("Total elapsed time: " + (after - before));
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        InstanceGenerator ig = new InstanceGenerator();
        List<Integer> list = ig.generateRandomInput(5,1000000);

        //System.out.println("Given List:");
        //printList(list);

        SortingAlgorithm ms = new Mergesort();
        SelectionAlgorithm qs = new Quickselect();
        SelectionAlgorithm rm = new RandomizedMedian(ms);


        printSelection(qs, list);

        printSelection(rm, list);

        printSorting(ms, list);
    }

    /**
     * Function used to compute the exact median from
     * a sorted list. Will be used just for checking.
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
}
