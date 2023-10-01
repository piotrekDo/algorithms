package codewars;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 * <p>
 * individual integers
 * or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"
 * Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.
 * <p>
 * Example:
 * <p>
 * Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
 * # returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
 */

public class RangeExtraction {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[]{-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> buffer = new LinkedList<>();
        IntStream.range(0, arr.length).forEach(i -> {
            int x = arr[i];
            int y = Integer.MAX_VALUE;
            if (i != arr.length - 1)
                y = arr[i + 1];

            if (y != x + 1) {
                buffer.add(x);
                if (buffer.size() > 2) {
                    result.append(buffer.getFirst());
                    result.append("-");
                    result.append(buffer.getLast());
                    result.append(",");
                    buffer.clear();
                } else {
                    buffer.forEach(number -> {
                        result.append(number);
                        result.append(",");
                    });
                    buffer.clear();
                }
            } else {
                buffer.add(x);
            }

        });
        buffer.forEach(number -> {
            result.append(number);
            result.append(",");
        });

        result.replace(result.length() -1, result.length(), "");
        return result.toString();
    }
}
