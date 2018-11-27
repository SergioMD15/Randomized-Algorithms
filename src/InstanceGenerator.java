import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is used to generate the random instances
 * that will be used as the input to test the different algorithms
 */
public class InstanceGenerator {

    private final int SIZE = 50000;
    private final int DIGITS = 3;

    /**
     * Function used to generate a random input
     * with a given size and each element with as much
     * digits as the parameter indicates.
     *
     * @param digits integer number representing
     *               the accuracy of the data.
     * @param size integer number representing
     *               the number of integers to be
     *		     generated for the sample.
     * @return A list containing the random sample.
     */
    public List<Integer> generateRandomInput(int digits, int size) {
        List<Integer> v = new ArrayList<>();
        Random rand = new Random();
        int seed = (int) (Math.pow(10,digits) - 1);
        for (int i = 0; i < size; i++)
            v.add(rand.nextInt(seed));
        return v;
    }

    /**
     * Function used to generate a random input
     * with size 50000 and each element with as much
     * digits as the parameter indicates.
     *
     * @param digits integer number representing
     *               the accuracy of the data.
     * @return A list containing the random sample.
     */
    public List<Integer> generateRandomInput(int digits) {
        return generateRandomInput(digits, SIZE);
    }

    /**
     * Function used to generate a random input
     * with the default values:
     * (size = 50000, digits = 3).
     * @return A list containing the random sample.
     */
    public List<Integer> generateRandomInput() {
        return generateRandomInput(DIGITS);
    }
}
