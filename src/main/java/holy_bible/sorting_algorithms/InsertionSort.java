package holy_bible.sorting_algorithms;

import java.util.Arrays;

import static java.lang.Math.round;

/**
 * <p>Sortowanie przez wstawianie jest efektywne dla nieiwlkiej liczby elementów. Działa w sposów, w jaki ludzie
 *  * często porządkują karty. Zaczynamy od "pustej" lewej ręki i zakrytej sterty kart na stole kolejno dobierając
 *  * następne i wstawiając je w odpowiednie miejsce w stosie w lewej ręce. Aby znaleźć właściwe miejsce dla karty
 *  * porównujemy ją z tymi które już mamy w ręce OD PRAWEJ. Przeskakujemy nad kolejnymi kartami dopóki nie natrafimy
 *  * na niższą.</p>
 * <strong>Liczby, które chcemy sortować nazywamy KLUCZAMI</strong>
 *
 * <p><i>Biblia, strona 17.<i/><p/>
 */
 class InsertionSort implements Sorting{

    @Override
    public String name() {
        return "Insertion sort";
    }

    @Override
    public int[] sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int key = ints[i];
            int prevIndex = i - 1;
            while (prevIndex > -1 && ints[prevIndex] > key) {
                ints[prevIndex + 1] = ints[prevIndex];
                prevIndex--;
            }
            ints[prevIndex + 1] = key;
        }
        return ints;
    }

    static int[] insertionComment(int[] ints) {
        for (int i = 1; i < ints.length; i++) {                 //1. zaczynamy od drugiego elementu
            int key = ints[i];                                  //2. wartosc drugiego elementu zapamietana

            int prevIndex = i - 1;                              //3. ustalamy index mniejszy o jeden
            while (prevIndex > -1 && ints[prevIndex] > key) {   //4. przesuwamy cala talie dopóki klucz jest mniejszy
                ints[prevIndex + 1] = ints[prevIndex];          //5. wstawiamy wartosc na prawo o +1 (dublując)
                prevIndex--;                                    //6. zmiejscamy index mniejszy o 1- sprawdzamy kolejna w lewo
            }
            ints[prevIndex + 1] = key;                          //7. kiedy dotrzemy do najmniejszej wartosci, wiekszej od klucza,
            //   lub poczaatku talii wstawiamy w to miejsce nasz klucz
            // prevIndex trzeba powiekszyc, poniewaz zostal zmniejszony
            // w porzednij iteracji a trafilismy na koniec
        }
        return ints;
    }
}

