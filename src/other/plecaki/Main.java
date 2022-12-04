package other.plecaki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/other/plecaki/day3.txt");
        List<String> strings = Files.readAllLines(path);
        Map<Character, Integer> charsCount = new HashMap<>();
        strings.forEach(str -> {
            String first = str.substring(0, str.length() / 2);
            String second = str.substring(str.length() / 2, str.length());
            for (char c : first.toCharArray()) {
                if (second.contains(String.valueOf(c))){
                    Integer orDefault = charsCount.getOrDefault(c, 0);
                    charsCount.put(c, orDefault + 1);
                    break;
                }
            }
        });
        int sum = 0;

        for (Map.Entry<Character, Integer> characterIntegerEntry : charsCount.entrySet()) {
            int lol = characterIntegerEntry.getValue() * getPriority(characterIntegerEntry.getKey());
            sum += lol;
        }

        System.out.println(sum);


        //STREAMY
//        List<String> first = Arrays.asList(Arrays.copyOfRange(chars, 0, chars.length / 2));
//        List<String> second = Arrays.asList(Arrays.copyOfRange(chars, chars.length / 2, chars.length));
//
//        Set<String> result = first.stream().filter(second::contains).collect(Collectors.toSet());
//
//        priority += result.stream().mapToInt(x -> GetPriority(x.charAt(0))).sum();
    }

    private static int getPriority(char value) {
        if (value >= 97 && value <= 122) {
            System.out.println(value -96);
            return value - 96;
        }

        if (value >= 65 && value <= 90) {
            return value - 38;
        }
        return 0;
    }
}
