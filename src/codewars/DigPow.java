package codewars;

public class DigPow {
    public static void main(String[] args) {
        System.out.println(digPow(695, 2)); //powinno dac 2;
        System.out.println(digPowClever(695, 2)); //powinno dac 2;
    }

    public static long digPowClever(int n, int p) {
        String intString = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < intString.length(); ++i, ++p)
            sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
        return (sum % n == 0) ? sum / n : -1;

//        int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
//        int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], i + p)).sum();
//        return sum % n == 0 ? sum / n : -1;
    }

    public static long digPow(int n, int p) {
        long result = 0;
        int powSum = 0;
        String stringOfN = String.valueOf(n);

        for (int i = 0; i < stringOfN.length(); i++) {
            int digit = Integer.parseInt(stringOfN.substring(i, i + 1));
            powSum += Math.pow(digit, p);
            p++;
        }
        long l = 0;
        while (l < powSum) {
            result++;
            l = n * result;
        }
        if (l == powSum)
            return result;
        else
            return -1;
    }
}
