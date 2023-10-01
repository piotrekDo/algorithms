package codewars;

import java.util.ArrayList;
import java.util.List;

public class SameNbDivisors {

    public static void main(String[] args) {
        System.out.println(countPairsInt(3, 200));
        ;
    }


    public static int countPairsInt(int diff, long nMax) {
        List<Integer> range = new ArrayList<>();
        range.add(0);
        int divisors = 0;
        int sameNbDivisors = 0;

        for (int i = 1; i < nMax; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisors++;
                }
            }
            range.add(divisors);
            divisors = 0;
        }

        for (int i = 0; i < range.size() - diff; i++) {
            if (range.get(i).equals(range.get(i + diff))) {
                sameNbDivisors++;
            }
        }
        return sameNbDivisors;
    }
}
