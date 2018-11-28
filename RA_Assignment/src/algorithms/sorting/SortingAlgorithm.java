package algorithms.sorting;

import algorithms.Algorithm;

import java.util.List;

public interface SortingAlgorithm extends Algorithm {

    /**
     * Sorts the given list.
     * @param list list to be sorted.
     */
    void sort(List<Integer> list);
}
