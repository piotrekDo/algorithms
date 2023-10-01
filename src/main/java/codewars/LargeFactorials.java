package codewars;

import java.math.BigDecimal;

public class LargeFactorials {
    public static void main(String[] args) {
        System.out.println(Factorial(5)); // 120
        System.out.println(Factorial(9)); //362880
        System.out.println(Factorial(15)); // 1307674368000
    }

    public static String Factorial(int n) {
        BigDecimal factorial = BigDecimal.valueOf(1);
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }
        return factorial.toString();
    }
}
