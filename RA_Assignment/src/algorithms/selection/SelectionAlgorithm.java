package algorithms.selection;

import algorithms.Algorithm;

import java.util.List;

public interface SelectionAlgorithm extends Algorithm {

    /**
     * Function that will be called from the main class
     * and will initialize the required elements and
     * then will execute the function representing
     * the algorithm.
     *
     * @param list List from which we want
     *                 to get the median.
     * @return The median of the list.
     */
    int execute(List<Integer> list);
}
