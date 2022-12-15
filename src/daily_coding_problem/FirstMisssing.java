package daily_coding_problem;

import java.util.Arrays;

public class FirstMisssing {

    public static void main(String[] args) {
        System.out.println(firstMissing(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissing(new int[]{1, 2, 0}));

    }

    static int firstMissing(int[] ints) {
        Arrays.sort(ints);

        for (int i = 0; i < ints.length; i++) {
            int current = ints[i];
            int next = i + 1 == ints.length ? ints[i] : ints[i + 1];

            if (next > current + 1 && current > 0) {
                return current + 1;
            }

        }
        return ints[ints.length - 1] + 1;
    }
}