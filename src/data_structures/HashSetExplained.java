package data_structures;

import java.util.HashSet;

/**
 * Java HashSet wewnętrznie wykorzystuje tablicę list do wstawiania, wyszukiwania i usuwania ze złożonością O(1).
 * HashSet najpierw oblicza hash obiektu, aby określić indeks tablicy, pod którym obiekt będzie przechowywany.
 * Później obiekt jest przechowywany pod obliczonym indeksem. Ta sama zasada obowiązuje podczas wyszukiwania i usuwania.
 * <p>
 * * Uzyskiwanie dostępu do elementu tablicy jest operacją O(1), więc jedynym narzutem jest obliczanie skrótu obiektu.
 * * Dlatego funkcja haszująca musi być optymalna, aby nie wpływała w żaden sposób na wydajność.
 * *
 * * Ponadto wynik tej funkcji powinien mieć równomierną dystrybucję. W przypadku kolizji,
 * * długość listy przy danym indeksie będzie rosła, a w najgorszym przypadku powikłaniem będzie O(n).
 * <img src="https://cdn.bulldogjob.com/system/photos/files/000/005/824/original/1_EYFpo0gXixdv8J7ctrPMDg.png"></img>
 *
 * wiecej na <a href="https://bulldogjob.pl/readme/ciekawy-przypadek-ciagu-hashcode-w-javie">KLIK</a>
 */


public class HashSetExplained {
    public static void main(String[] args) {

        // HashSet korzystając z tablicy określa index poprzez wynik modulo 8 dla uzyskanego kodu hash
        // w ten sposób wynik reszty z dzielenia poda nam index tablicy

        System.out.println("abc".hashCode() % 8); //2
        System.out.println("foo".hashCode() % 8); //6
        System.out.println("lol".hashCode() % 8); //1
        System.out.println("Piotrek".hashCode() % 8); //2


    }
}
