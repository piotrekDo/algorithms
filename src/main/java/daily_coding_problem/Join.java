package daily_coding_problem;

import java.util.Arrays;

public class Join {

    public static void main(String[] args) {
        int[] ints = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(sortArray(ints)));

        String lol = 8 + "21" + 2.4;

    }
    int x = 7;

    public <T> void dump(T[] table){
        for (T t : table) {
            System.out.println(t);
        }
    }
    // [-37, -2, -2, -23, -18, 44, 16, -19] should equal [-37, -2, -23, -18, 44, 16, -19, -2]
    // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
    //[5, 8, 3, 6, 1, 4, 7, 2, 9, 0]


    public static int[] sortArray(int[] array) {
        //sprawdzenie rozmiaru tablicy
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                length++;
            }
        }

        //teraz dopiero wrzucanie nieparzystych...
        int[] odds = new int[length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                odds[index] = array[i];
                index++;
            }
        }

        //reczne sortowanie nieparzystych
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < odds.length - 1; i++) {
                if (odds[i] > odds[i + 1]) {
                    int tmp = odds[i];
                    odds[i] = odds[i + 1];
                    odds[i + 1] = tmp;
                    sorted = false;
                }
            }
        } while (!sorted);

        //i dopiero do tablicy
        index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[i] = odds[index];
                index++;
            }
        }
        return array;
    }


//    public static int[] sortArray(int[] array) {
//        boolean sorted = true;
//        do {
//            sorted = true;
//            int test = Integer.MIN_VALUE;
//            int test2 = Integer.MIN_VALUE;
//            for (int i = 0; i <= array.length - 1; i++) {
//                if (array[i] % 2 != 0 && test == Integer.MIN_VALUE) {
//                    test = i;
//                } else if (array[i] % 2 != 0 && test2 == Integer.MIN_VALUE) {
//                    test2 = i;
//                    if (array[test] > array[test2]) {
//                        int tmm = array[test];
//                        array[test] = array[test2];
//                        array[test2] = tmm;
//                        i--;
//                        test = Integer.MIN_VALUE;
//                        test2 = Integer.MIN_VALUE;
//                        sorted = false;
//                    }
//                }
//            }
//        } while (!sorted);
//        return array;
//    }
}

