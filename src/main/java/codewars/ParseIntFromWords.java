package codewars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.
 * Examples:
 * "one" => 1
 * "twenty" => 20
 * "two hundred forty-six" => 246
 * "seven hundred eighty-three thousand nine hundred and nineteen" => 783919
 * Additional Notes:
 * <p>
 * The minimum number is "zero" (inclusively)
 * The maximum number, which must be supported is 1 million (inclusively)
 * The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
 * All tested numbers are valid, you don't need to validate them
 */
public class ParseIntFromWords {

    public static void main(String[] args) {
//        System.out.println(parseInt("two thousand twenty-two"));
//        System.out.println(parseInt("two hundred forty-six"));
        System.out.println(parseInt("two hundred forty-six"));
        System.out.println(parseInt("six hundred eighty-eight"));
//        System.out.println(parseInt("eleven"));
//        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
        System.out.println(parseInt(""));
    }

    public static int parseInt(String numStr) {
        if (numStr == null || numStr.isEmpty() || numStr.isBlank())
            return 0;
        Map<String, Integer> map = getStringIntegerMap();
        String[] words = numStr.split(" ");
        List<String> strings = Arrays.stream(words).toList();
        List<Integer> collect = strings.stream()
                .filter(x -> x.contains("-") || map.containsKey(x))
                .map(x -> {
                    if (x.contains("-")) {
                        String[] split = x.split("-");
                        Integer integer = map.get(split[0]);
                        Integer integer1 = map.get(split[1]);
                        return integer + integer1;
                    } else {
                        return map.get(x);
                    }
                }).collect(Collectors.toList());

        Optional<Integer> max = collect.stream().max(Integer::compare);
        if (max.isPresent()) {
            Integer top = max.get();
            int indexOfTop = collect.indexOf(top);
            List<Integer> firstHalf = new ArrayList<>();
            List<Integer> secondHalf = new ArrayList<>();
            IntStream.range(0, indexOfTop + 1).forEach(i -> firstHalf.add(collect.get(i)));
            IntStream.range(indexOfTop + 1, collect.size()).forEach(i -> secondHalf.add(collect.get(i)));
            Integer first = firstHalf.stream().reduce(0, (x, y) -> y == 100 || y == 1000 || y == 1000000 ? x * y : x + y);
            Integer second = secondHalf.stream().reduce(0, (x, y) -> y == 100 || y == 1000 || y == 1000000 ? x * y : x + y);
            return first + second;
        }
        return 0;
    }


    private static Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);
        return map;
    }

}
