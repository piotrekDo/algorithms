package daily_coding_problem;

import java.util.Arrays;

public class Recalculate {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(recalculate(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(recalculateWhile(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(recalculateDivision(new int[]{1, 2, 3, 4, 5})));

        System.out.println(Arrays.toString(recalculate(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(recalculateWhile(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(recalculateDivision(new int[]{3, 2, 1})));
    }

    static int[] recalculate(int[] ints) {
        int[] result = new int[ints.length];
        int sum = 1;

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                sum *= j == i ? 1 : ints[j];
            }
            result[i] = sum;
            sum = 1;
        }
        return result;
    }

    static int[] recalculateWhile(int[] ints) {
        int[] result = new int[ints.length];
        int sum = 1;
        boolean sorted = false;
        int iteration = 0;

        while (!sorted) {
            for (int j = 0; j < ints.length; j++) {
                sum *= j == iteration ? 1 : ints[j];
            }
            result[iteration] = sum;
            sum = 1;
            iteration++;
            sorted = iteration == ints.length;
        }
        return result;
    }

    static int[] recalculateDivision(int[] ints) {
        int[] result = new int[ints.length];
        int sum = 1;

        for (int i = 0; i < ints.length; i++) {
            sum *= ints[i];
        }

        for (int i = 0; i < ints.length; i++) {
            result[i] = sum / ints[i];
        }

        return result;
    }
}


