package algorithms.selection;

import algorithms.sorting.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomizedMedian implements SelectionAlgorithm {

    private SortingAlgorithm mergesort;

    public RandomizedMedian(SortingAlgorithm mergesort){
        this.mergesort = mergesort;
    }

    @Override
    public int execute(List<Integer> list){
        int n = list.size();
        int r_size = (int) Math.pow(n,0.75);

        Random rand = new Random();
        List<Integer> R = new ArrayList<>();

        for(int i = 0; i < r_size; i++){
            R.add(list.get(rand.nextInt(n)));
        }

        mergesort.sort(R);
        int d = R.get((int) (r_size/2 - Math.pow(n,0.5)));
        int u = R.get((int) (r_size/2 + Math.pow(n,0.5)));

        List<Integer> C = list.stream().filter(x -> x <= u && x >= d).collect(Collectors.toList());

        int l_d = (int) list.stream().filter(x -> x < d).count();
        int l_u = (int) list.stream().filter(x -> x > u).count();

        if(l_d > n/2 || l_u > n/2)
            return -1;
        if(C.size() <= (4*r_size)){
            mergesort.sort(C);
        } else {
            return -1;
        }
        return C.get((int)(n/2) - l_d + 1);
    }

    @Override
    public String getName() {
        return "Randomized Median";
    }
}
