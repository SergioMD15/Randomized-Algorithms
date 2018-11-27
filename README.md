# Randomized-Algorithms

This project consists in implementing two selection algorithms capable of finding the median of any given random sample in a very small time. Also, it is necessary to implement a sorting algorithm (Mergesort) in this case to compare the execution time of both algorihtms with respect to the easy way, sorting the whole array and select the element which is in the middle.

## Implemented Algorithms

* Mergesort. Sorting algorithm that divides the list into two halfs recursively to order them and then merge into the final result.

* Quickselect. Selection algorithm invented by Tony Hoare (creator of Quicksort also), that consists in dividing the list using a pivot and finding the k_th smallest element (in this case, the k_th element is the n/2 element, i.e. the median). There is a significant difference in this implementation, instead of following a heuristic to choose a good pivot, this selection is done u.a.r.

* Randomized Median. This algorithm is proposed in the Mitzenmacher and Upfal's book "Probability and Computing: Randomized Algorithms and Probabilistic Analysis". Uses filtering and sampling techniques to find a random sample the w.h.p contains the median. The results obtained with this algorithm are not always exact.

## Instance Generator

To try the algorithms, at first I'm using instances generated at random, but I will upload soon a file containing at least 100 instances where some of them will represent special cases to test the efficiency of the algorithms.