package algorithms.selection;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Quickselect implements SelectionAlgorithm {

    @Override
    public int execute(List<Integer> instance) {
        List<Integer> A = instance;
        int n = A.size();
        if (n % 2 == 1) {
            return algorithm(A, n / 2);
        } else {
            return (int) (0.5 * (algorithm(A, n / 2 - 1) + algorithm(A, n / 2)));
        }
    }

    @Override
    public String getName() {
        return "QuickSelect";
    }

    /**
     * Main function of the class. It represents the random
     * Quickselect algorithm and finds the median in linear
     * time O(n) (best case).
     *
     * @param list The instance that contains the median.
     * @param index The position of the element that we want.
     * @return The median of the list.
     */
    private int algorithm(List<Integer> list, int index) {
        if (list.size() == 1) {
            assert index == 0;
            return list.get(0);
        }

        int pivot = random_partition(list);

        List<Integer> lows = list.stream().filter(el -> el < pivot).collect(Collectors.toList());
        List<Integer> highs = list.stream().filter(el -> el > pivot).collect(Collectors.toList());
        List<Integer> pivots = list.stream().filter(el -> el == pivot).collect(Collectors.toList());

        if (index < lows.size())
            return algorithm(lows, index);
        else if (index < lows.size() + pivots.size())
            // We got lucky and guessed the median
            return pivots.get(0);
        else
            return algorithm(highs, index - lows.size() - pivots.size());
    }

    /**
     * Function to compute the pivot randomly.
     * @param list The instance that contains the pivot.
     * @return A random pivot.
     */
    private int random_partition(List<Integer> list) {
        Random rn = new Random();
        return list.get(rn.nextInt(list.size()));
    }
}
