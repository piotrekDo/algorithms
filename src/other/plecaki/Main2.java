package other.plecaki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/other/plecaki/day3.txt");
        List<String> strings = Files.readAllLines(path);

        int priority = 0;

        for (int i = 0; i < strings.size(); i += 3) {
            List<String> first = Arrays.asList(strings.get(i).split(""));
            List<String> second = Arrays.asList(strings.get(i + 1).split(""));
            List<String> third = Arrays.asList(strings.get(i + 2).split(""));

            Set<String> inter = first.stream().filter(second::contains).collect(Collectors.toSet());
            Set<String> result = inter.stream().filter(third::contains).collect(Collectors.toSet());

            priority += result.stream().mapToInt(x -> GetPriority(x.charAt(0))).sum();
        }

        System.out.println(priority);
    }

    private static int GetPriority(char value) {
        if (value >= 97 && value <= 122) {
            return value - 96;
        }

        if (value >= 65 && value <= 90) {
            return value - 38;
        }

        return 0;
    }
}
