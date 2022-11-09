package holy_bible.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SortingComparator {
    public static void main(String[] args) {
        Sorting bubbleSort = new BubbleSort();
        Sorting insertIonSort = new InsertionSort();
        Sorting mergeSort = new MergeSort();

        int[] randoms = getRandoms(100_000, 1_000);

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(()-> bubbleSort.printResult(Arrays.copyOf(randoms, randoms.length), true));
        executor.execute(()-> insertIonSort.printResult(Arrays.copyOf(randoms, randoms.length), true));
        executor.execute(()-> mergeSort.printResult(Arrays.copyOf(randoms, randoms.length), true));


//        bubbleSort.printResult(Arrays.copyOf(randoms, randoms.length), true);
//        insertIonSort.printResult(Arrays.copyOf(randoms, randoms.length), true);
//        mergeSort.printResult(Arrays.copyOf(randoms, randoms.length), true);

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
