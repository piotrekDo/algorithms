package holy_bible.sorting_algorithms;

public class MergeSort implements Sorting{

    @Override
    public String name() {
        return "Merge sort";
    }

    @Override
    public int[] sort(int[] ints) {
        int p = 1;
        int r = ints.length;

        if (p < r) {
            int q = (p + r) / 2;
            mergeSortInner(ints, p, q);
            mergeSortInner(ints, q + 1, r);
            merge(ints, p, q, r);
        }
        return ints;
    }

    private static int[] mergeSortInner(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortInner(A, p, q);
            mergeSortInner(A, q + 1, r);
            merge(A, p, q, r);
        }
        return A;
    }

    private static int[] merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i - 1];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q + i];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p - 1; k < r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i = i + 1;
            } else {
                A[k] = R[j];
                j = j + 1;
            }
        }
        return A;
    }


    /*
    SORT Z KSIĄŻKI
     */


    static int[] mergeSortBook(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortBook(A, p, q);
            mergeSortBook(A, q + 1, r);
            mergeBook(A, p, q, r);
        }
        return A;
    }

    private static int[] mergeBook(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i - 1];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q + i];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p - 1; k < r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i = i + 1;
            } else {
                A[k] = R[j];
                j = j + 1;
            }
        }
        return A;
    }
}
