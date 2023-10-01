package codewars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeightForWeight {
    public static void main(String[] args) {
        System.out.println(orderWeight("56 65 74 100 99 68 86 180 90"));
        System.out.println(orderWeight2("56 65 74 100 99 68 86 180 90"));
        //"100 180 90 56 65 74 68 86 99"
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(orderWeight2("2000 10003 1234000 44444444 9999 11 11 22 123"));
        //11 11 2000 10003 22 123 1234000 44444444 9999
    }

    public static String orderWeight2(String weights) {
        return Stream.of(weights.trim().split(" +"))
                .sorted()
                .sorted(Comparator.comparingInt(o -> o.chars().map(Character::getNumericValue).sum()))
                .collect(Collectors.joining(" "));
    }

    public static String orderWeight(String input) {
        String[] split = input.trim().split("\\D");
        Arrays.sort(split);
        Map<Integer, ArrayList<String>> integerMap = new TreeMap<>();
        Arrays.stream(split).forEach(str -> {
            int sum = IntStream.range(0, str.length()).map(i -> Character.getNumericValue(str.charAt(i))).sum();
            if (!integerMap.containsKey(sum)){
                integerMap.put(sum, new ArrayList<>());
            }
            integerMap.get(sum).add(str);
        });
        StringBuilder sb = new StringBuilder();
        integerMap.forEach((key, value) -> value.forEach(val -> {
            sb.append(val);
            sb.append(" ");
        }));
        return sb.toString().trim();
    }
}
