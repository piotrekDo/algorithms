package daily_coding_problem;

import java.util.Arrays;

public class Ex_14FindNumberOfSmallerEmelentsToTheRight {
    public static void main(String[] args) {
        /**
         * BISECT NIE DZIAŁA!
         */

        System.out.println(Arrays.toString(find(new int[]{3, 4, 9, 6, 1}))); // powinno dac 1, 1, 2, 1, 0
        System.out.println(Arrays.toString(find(new int[]{1, 2, 3, 4, 5}))); // powinno dac 0, 0, 0, 0, 0
        System.out.println(Arrays.toString(find(new int[]{12, 1, 2, 3, 0, 11, 4}))); // powinno dac 6, 1, 1, 1, 0, 1, 0
        System.out.println(Arrays.toString(bisect(new int[]{12, 1, 2, 3, 0, 11, 4}))); // powinno dac 6, 1, 1, 1, 0, 1, 0
    }

    private static int[] find(int[] tab) {
        int[] result = new int[tab.length];

        for (int i = 0; i < tab.length; i++) {
            int count = 0;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[i])
                    count++;
            }
            result[i] = count;
        }
        return result;
    }

    private static int[] bisect(int[] tab) {
        int[] result = new int[tab.length];
        int[] seen = new int[tab.length];

        for (int i = tab.length - 1; i >= 0; i--) {
            int position  = bisect_left(seen, tab[i]);
            result[i] = position;
        }

        return result;
    }


    public static int bisect_right(int[] A, int x) {
        return bisect_right(A, x, 0, A.length);
    }

    public static int bisect_right(int[] A, int x, int lo, int hi) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        if (x < A[lo]) {
            return lo;
        }
        if (x > A[hi - 1]) {
            return hi;
        }
        for (; ; ) {
            if (lo + 1 == hi) {
                return lo + 1;
            }
            int mi = (hi + lo) / 2;
            if (x < A[mi]) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }

    public static int bisect_left(int[] A, int x) {
        return bisect_left(A, x, 0, A.length);
    }

    public static int bisect_left(int[] A, int x, int lo, int hi) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        if (x < A[lo]) {
            return lo;
        }
        if (x > A[hi - 1]) {
            return hi;
        }
        for (; ; ) {
            if (lo + 1 == hi) {
                return x == A[lo] ? lo : (lo + 1);
            }
            int mi = (hi + lo) / 2;
            if (x <= A[mi]) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }

}
