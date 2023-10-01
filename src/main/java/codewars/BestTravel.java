package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTravel {
    public static void main(String[] args) {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 57, 58, 60)); // suma 280 srednia 56, perfect 58
        System.out.println(chooseBestSum(174, 3, ts));
        //powinno dac 173 wybierajac 55, 58, 60;
        //162, 170, 175
    }

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        int result = -1;
        for (int i = 0; i < ls.size(); ++i) {
            if (ls.get(i) <= t) {
                if (k == 1) {
                    result = Math.max(result, ls.get(i));
                } else {
                    Integer temp = chooseBestSum(t - ls.get(i), k - 1, ls.subList(i + 1, ls.size()));
                    if (temp != null) {
                        result = Math.max(result, ls.get(i) + temp);
                    }
                }
            }
        }

        if (result < 0) return null;
        return result;
    }

}
