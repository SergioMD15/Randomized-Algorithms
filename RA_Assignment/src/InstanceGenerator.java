import algorithms.sorting.Mergesort;
import algorithms.sorting.SortingAlgorithm;

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
    private SortingAlgorithm sortingAlgorithm;

    public InstanceGenerator(){
        this.sortingAlgorithm = new Mergesort();
    }

    /**
     * BASE FUNCTION.
     * Function used to generate a random input
     * with a given size and each element with as much
     * digits as the parameter indicates.
     *
     * @param digits integer number representing
     *               the accuracy of the data.
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

    /**
     * BASE FUNCTION.
     * Function used to generate a random sample
     * and then order it.
     * @param digits number of digits for the
     *      *        elements of the list.
     * @param size size of the instance generated.
     * @return returns an ordered list.
     */
    public List<Integer> generateSortedInput(int digits, int size){
        List<Integer> list = generateRandomInput(digits, size);
        sortingAlgorithm.sort(list);
        return list;
    }

    /**
     * Function used to generate a random sample
     * and then order it.
     * @param digits number of digits for the
     *               elements of the list.
     * @return returns an ordered list
     */
    public List<Integer> generateSortedInput(int digits){
        return generateSortedInput(digits,SIZE);
    }

    /**
     *Function used to generate a random sample
     *      * and then order it.
     * @return returns an ordered list.
     */
    public List<Integer> generateSortedInput(){
        return generateSortedInput(DIGITS);
    }

    /**
     * BASE FUNCTION.
     * Function used to generate a list full of zeros.
     * @param size size of the instance generated.
     * @return returns a list full of zeros.
     */
    public List<Integer> generateZerosList(int size){
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < size; i++)
            v.add(0);
        return v;
    }

    /**
     * Function used to generate a list full of zeros.
     * @return returns a list full of zeros.
     */
    public List<Integer> generateZerosList(){
        return generateZerosList(SIZE);
    }

    /**
     * BASE FUNCTION.
     * Function used to generate a list full of a couple
     * of numbers.
     * @param size size of the instance generated.
     * @return returns a list full of zeros.
     */
    public List<Integer> generateTuplesList(int size){
        List<Integer> v = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            v.add(rand.nextInt(2));
        return v;
    }

    /**
     * Function used to generate a list full of a couple
     * of numbers.
     * @return returns a list full of zeros.
     */
    public List<Integer> generateTuplesList(){
        return generateTuplesList(SIZE);
    }

}
