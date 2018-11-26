import algorithms.Mergesort;
import algorithms.Quickselect;

import java.util.List;

public class Main {

    /**
     * Useful function to print the a list.
     * @param list The list to be printed.
     */
    private static void printList(List<Integer> list) {
        list.forEach(e -> System.out.print(e + " "));
    }

    // Driver method
    public static void main(String args[]) {
        InstanceGenerator ig = new InstanceGenerator();
        List<Integer> list = ig.generateRandomInput();

        System.out.println("Given Array:");
        printList(list);

        Mergesort ms = new Mergesort();

        System.out.println("Median obtained with quickselect:");
        Quickselect qs = new Quickselect();
        System.out.println(qs.execute(list));

        //System.out.println("Median obtained with randomized median:");
        //algorithms.RandomizedMedian rm = new algorithms.RandomizedMedian(ob);
        //System.out.println(rm.execute(arr));


        ms.sort(list);

        System.out.println("\nSorted array");
        printList(list);

        System.out.println("\nReal median");
        median(list);
    }

    /**
     * Function used to compute the exact median from
     * a sorted list. Will be used just for checking.
     * @param list The sorted list where the median
     *             will be obtained.
     */
    private static void median(List<Integer> list){
        int median;
        if (list.size() % 2 == 0){
            median = (list.get(list.size()/2) + list.get(list.size()/2 - 1))/2;
        } else{
            median = list.get(list.size()/2);
        }
        System.out.println(median);
    }
}
