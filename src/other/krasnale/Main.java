package other.krasnale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/other/krasnale/zadanie1.txt");
        List<String> strings = Files.readAllLines(path);
        List<Integer> result = new ArrayList<>();
        List<String> collect = strings.stream().map(s -> {
            String[] split = s.split(" ");
            return split[0];
        }).collect(Collectors.toList());
        System.out.println(collect);


//        BufferedReader br = new BufferedReader(new FileReader("src/other/krasnale/zadanie1.txt"));
//
//        int calorie = 0;
//
//        List<Integer> calorieList = new ArrayList<>();
//
//        String line;
//
//        while ((line = br.readLine()) != null) {
//            String strCal = line.trim();
//            if (strCal.isBlank()) {
//                calorieList.add(calorie);
//                calorie = 0;
//                continue;
//            }
//            calorie += Integer.parseInt(strCal);
//        }
//        calorieList.add(calorie);
//        calorieList.sort(Comparator.reverseOrder());
//        int mostCalories = calorieList.stream().max(Integer::compare).get();
//
//        System.out.println(mostCalories);
//
//        System.out.println(calorieList);
//
//        Integer integer = calorieList.get(0);
//        Integer integer2 = calorieList.get(1);
//        Integer integer3 = calorieList.get(2);
//
//        System.out.println(integer + integer3 + integer2);
        }
    }
