package daily_coding_problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex_21FindAnagramIndices {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find("ab", "abxaba"))); // powinno da 0,3,4
    }

    private static int[] find(String word, String string) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = string.length() - word.length() + 1;

        for (int i = 0; i < n; i++) {
            String window = string.substring(i, i + word.length());
            if (isAnagram(window, word)) {
                result.add(i);
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static boolean isAnagram(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        int[] ascii = new int[58];
        for (char s1Char : s1Chars) {
            int i = (int) s1Char - 65;
            ascii[i]++;
        }
        for (char s2Char : s2Chars) {
            int i = (int) s2Char - 65;
            ascii[i]++;
        }
        for (int i : ascii) {
            if (i % 2 != 0)
                return false;
        }
        return true;
    }
}
