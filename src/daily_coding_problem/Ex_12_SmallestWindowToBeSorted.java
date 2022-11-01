package daily_coding_problem;

import java.util.Arrays;

public class Ex_12_SmallestWindowToBeSorted {

    public static void main(String[] args) {
        int[] window = window(new int[]{1, 2, 4, 3, 5, 6});
        int[] windowEfficient = windowEfficient(new int[]{1, 2, 4, 3, 5, 6});
        System.out.println(Arrays.toString(window));
        System.out.println(Arrays.toString(windowEfficient));
    }

    // kopiujemy tablice, porownujemy wynik z posortowana i zwracamy indexy ktore sie nie zgadzaja
    private static int[] window(int[] tab) {
        int left = -1;
        int right = -1;
        int[] sorted = Arrays.copyOf(tab, tab.length);
        Arrays.sort(sorted);

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != sorted[i] && left == -1)
                left = i;
            else if (tab[i] != sorted[i])
                right = i;
        }
        return new int[]{left, right};
    }

    private static int[] windowEfficient(int[] tab) {
        int left = -1;
        int right = -1;
        int n = tab.length;
        int max_seen = Integer.MIN_VALUE;
        int min_seen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (max_seen < tab[i]) {
                max_seen = tab[i];
            }
            // find the last position that is less than the maximum so far
            if (tab[i] < max_seen) {
                right = i;
            }
        }
        // traverse from right to left and keep track of the minimum so far
        for (int i = n - 1; i >= 0; i--) {
            if (min_seen > tab[i]) {
                min_seen = tab[i];
            }
            // find the last position that is more than the minimum so far
            if (tab[i] > min_seen) {
                left = i;
            }
        }
        return new int[]{left, right};
    }

}
