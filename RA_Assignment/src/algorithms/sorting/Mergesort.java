package algorithms.sorting;

import algorithms.selection.SelectionAlgorithm;

import java.util.List;

public class Mergesort implements SortingAlgorithm {

    /**
     * This function merges two sublists of the first parameter
     * where the first sublist is like [l, ..., m],
     * and the second is lik [m + 1, ..., r].
     *
     * @param list list to be merged
     * @param l left point to start.
     * @param m pivot value.
     * @param r right point to finish.
     */
    private void merge(List<Integer> list, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = list.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = list.get(m + 1 + j);


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list.set(k,L[i]);
                i++;
            } else {
                list.set(k,R[j]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            list.set(k,L[i]);
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            list.set(k,R[j]);
            j++;
            k++;
        }
    }

    /**
     * MAIN FUNCTION. Sorts the array specifying a left
     * starting point, and a right ending point to sort.
     * @param list list to be sorted.
     * @param l left point to start.
     * @param r right point to finish.
     */
    public void sort(List<Integer> list, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(list, l, m);
            sort(list, m + 1, r);

            // Merge the sorted halves
            merge(list, l, m, r);
        }
    }

    @Override
    public void sort(List<Integer> arr){
        sort(arr, 0, arr.size()-1);
    }

    @Override
    public String getName() {
        return "MergeSort";
    }
}
