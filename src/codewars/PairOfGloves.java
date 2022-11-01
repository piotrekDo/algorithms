package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PairOfGloves {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new String[]{"red", "red", "green", "red", "blue", "blue", "red"}));
    }

    public static int numberOfPairs(String[] gloves) {
        int count = 0;
        gloves = Arrays.stream(gloves).sorted().toArray(String[]::new);
        for (int i = 0; i < gloves.length - 1; i++) {
            String current = gloves[i];
            String next = gloves[i + 1];
            if (current != null && next != null) {
                if (current.equals(next)) {
                    gloves[i] = null;
                    gloves[i+1] = null;
                    count ++;
                }
            }
        }
        return count;
    }

    public static int numberOfPairs2(String[] gloves) {
        return (int) Arrays.asList(gloves).stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .mapToLong(entry -> entry.getValue() / 2)
                .sum();
    }
}
