package daily_coding_book;
import java.util.Arrays;

public class GetProductOfAllOtherElements {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(get(input)));
        System.out.println(Arrays.toString(get(input)));
    }

    static int[] get(int[] input) {
        int[] output = new int[input.length];
        int result = 1;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (j == i) {
                    continue;
                }
                result *= input[j];
            }
            output[i] = result;
            result = 1;
        }
        return output;
    }

    static int[] getByDivision(int[] input) {
        int[] output = new int[input.length];
        int result = 1;

        for (int i = 0; i < input.length; i++) {
            result *= i;
        }

        return output;
    }
}
