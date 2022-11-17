package other;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciIteration(10));
    }

    /**
     * Definiujemy kolejno trzy zmienne : fib1, fib2 które przyjmują wartość 1 oraz Fibonacci która będzie pełnić role sumy.
     * W tym rozwiązaniu wykorzystujemy pętle for w której iteracje rozpoczynamy od 3.
     * Wcześniejsze iteracje zostały zdefiniowane już w instrukcji warunkowej.
     * Natomiast w pętli suma równa się sumie dwóm kolejnym zmiennym.
     * W kolejnych wierszach widzimy przypisanie zmiennej fib1 do fib2 oraz fib2 do fibonacci.
     * Oznacza tyle że np: liczba 3 która występowała jako fib2 teraz jest zmienna fib1.
     * Zmienną fib2 jest zaś suma czyli 5 (ponieważ fib1 = 2 + fib2 =3).
     */

    private static int fibonacciIteration(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        int fib1 = 1, fib2 = 1, fibonacci = 1;
        for (int i = 3; i <= number; i++) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }
}
