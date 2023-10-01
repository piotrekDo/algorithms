package daily_coding_problem;

import java.util.Arrays;

/**
 * [34, -50, 42, 14, -5, 86]
 * usyzkac najlepszy wynik z nieprzerwanego ciagu, w tym przypadku
 * 42, 14, -5, 86 da najwyzszy w postaci 137
 */
public class Ex_13CalculateMaximumSubarraySum {

    public static void main(String[] args) {
//        System.out.println(brute(new int[]{34, -50, 42, 14, -5, 86}));
//        System.out.println(brute(new int[]{-5, -1, -8, -9}));
//        System.out.println(kadanesAlgorithm(new int[]{34, -50, 42, 14, -5, 86}));
//        System.out.println(kadanesAlgorithm(new int[]{34, -50, 42, 14, -5, 86, -130, 90}));
        System.out.println(kadanesAlgorithm(new int[]{8, -1, 3, 4}));
        System.out.println(kadanesAlgorithm(new int[]{-8, -1, -3, -4}));
        System.out.println(kadaneWrap(new int[]{8, -1, 3, 4}));

    }

    /**
     * najprostrzym spsosobem bedzie brute force, czyli przjscie po kazdym mozliwym wyniku
     * i sprawdzenie czy jest on najwyższy
     */
    private static int brute(int[] array) {
        int n = array.length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int max = array[i];
            result = Math.max(max, result);
            for (int j = i + 1; j < n; j++) {
                max += array[j];
                result = Math.max(max, result);
            }
        }
        return result;
    }

    /**
     * Algorytm Kadane'a- algorytm sprawdza sume ciagu zaczynajac od 0 indexu i jsest przerywany
     * w moencie zejscia ponizej zera, wtedy startowy index sie przesuwa, a przechowywyany jest maxymalny wynik do tej pory
     * algorytm nie zadziala jezeli tablica zawiera same ujemne wartosci
     */
    private static int kadanesAlgorithm(int[] tab) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < tab.length; i++) {
            max_ending_here += tab[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

    /**
     * w scenariusz z przestawianiem zakldamy,że część wyników została odrzucona i utworzą one najmniejszą możliwą tablice
     * znajdujemy więć najmnijesą tablicę odwracając algorytm Kadane i odejmujemy go od calkowicej sumy tablicy.
     * Na końcu porównujemy najkorzystniejszy wynik z tym uzyskanym przed chwilą
     */
    private static int kadaneWrap(int[] tab) {
        int sum = Arrays.stream(tab).sum();
        int max_subarray = kadanesAlgorithm(tab);

        int min_endig_here = 0;
        int min_so_far = Integer.MAX_VALUE;
        for (int i = 0; i < tab.length; i++) {
            min_endig_here += tab[i];
            if (min_so_far > min_endig_here) {
                min_so_far = min_endig_here;
            }
            if (min_endig_here > 0) {
                min_endig_here = 0;
            }
        }
        int max_subarray_sum_wraparound = sum - min_so_far;
        return Math.max(max_subarray, max_subarray_sum_wraparound);
    }

}
