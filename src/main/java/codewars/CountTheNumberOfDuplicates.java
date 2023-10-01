package codewars;

import java.util.HashMap;

public class CountTheNumberOfDuplicates {
    //"abcde" -> 0  # no characters repeats more than once
    //"aabbcde" -> 2  # 'a' and 'b'
    //"aabBcde" -> 2  # 'a' occurs twice and 'b' twice (`b` and `B`)
    //"indivisibility" -> 1  # 'i' occurs six times
    //"Indivisibilities" -> 2  # 'i' occurs seven times and 's' occurs twice
    //"aA11" -> 2  # 'a' and '1'
    //"ABBA" -> 2  # 'A' and 'B' each occur twice

    public static void main(String[] args) {
        System.out.println(duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
    }

    public static int duplicateCount(String text) {
        HashMap<Integer, Integer> map = new HashMap<>();
        text.toLowerCase().chars().forEach(ch -> map.put(ch, map.getOrDefault(ch, 0) + 1));
        return ((int) map.values().stream().filter(x -> x > 1).count());
    }
}