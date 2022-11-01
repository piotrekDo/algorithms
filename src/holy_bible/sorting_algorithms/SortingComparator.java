package holy_bible.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class SortingComparator {
    public static void main(String[] args) {
        Sorting bubbleSort = new BubbleSort();
        Sorting insertIonSort = new InsertionSort();
        Sorting mergeSort = new MergeSort();

        int[] randoms = getRandoms(100000, 1000);

        bubbleSort.printResult(randoms, true);
//        insertIonSort.printResult(randoms, true);
//        mergeSort.printResult(randoms, true);

//        System.out.println(Arrays.toString(bubbleSort.sort(randoms)));
    }


    private static int[] getRandoms(int length, int bound) {
        Random random = new Random();
        int[] randoms = new int[length];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = random.nextInt(bound);
        }
        return randoms;
    }
}
