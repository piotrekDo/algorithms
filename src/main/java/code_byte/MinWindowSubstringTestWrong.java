package code_byte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MinWindowSubstringTestWrong {

    public static String MinWindowSubstring(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        char[] nChars = N.toCharArray();

        for (int i = 0; i < nChars.length; i++) {
            if (K.contains(String.valueOf(nChars[i])))
                continue;
            nChars[i] = Character.MIN_VALUE;
        }

        int[] ascii = new int[26];
        for (int i = 0; i < K.length(); i++) {
            if (K.charAt(i) == Character.MIN_VALUE)
                continue;
            ascii[(int) K.charAt(i) - 97]++;
        }

        int[] asciiN = new int[26];
        for (char nChar : nChars) {
            if (nChar == Character.MIN_VALUE)
                continue;
            asciiN[(int) nChar - 97]++;
        }
        System.out.println("TABLICA CHAROW Z GLOWNEGO CIAGU");
        printResult(nChars);

        for (int i = 0; i < asciiN.length; i++) {
            char x = (char) (i + 97);
            int toDelete = asciiN[i] - ascii[i];

            int start = 0;
            int end = nChars.length - 1;
            while (toDelete > 0) {
                if (nChars[start] == x) {
                    nChars[start] = Character.MIN_VALUE;
                    toDelete--;
                }
                if (toDelete < 1)
                    break;
                start++;
                if (nChars[end] == x) {
                    nChars[end] = Character.MIN_VALUE;
                    toDelete--;
                }
                end--;
            }
        }
        int subStart = -1;
        int subEnd = -1;
        for (int i = 0; i < nChars.length; i++) {
            if (nChars[i] != Character.MIN_VALUE) {
                subStart = i;
                break;
            }
        }
        for (int i = nChars.length - 1; i >= 0; i--) {
            if (nChars[i] != Character.MIN_VALUE) {
                subEnd = i;
                break;
            }
        }
        print(ascii);
        print(asciiN);
        printResult(nChars);
        return N.substring(subStart, subEnd + 1);
    }


    private static void printResult(char[] nChars) {
        for (int i = 0; i < nChars.length; i++) {
            if (nChars[i] == Character.MIN_VALUE) {
                System.out.print("   ");
            } else {
                System.out.print(nChars[i] + "  ");
            }
            if (i > 9)
                System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < nChars.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


    private static void print(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == Character.MIN_VALUE) {
                System.out.print("   ");
            } else {
                System.out.print(tab[i] + "  ");
            }
            if (i > 9)
                System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            System.out.print((char) (i + 97) + "  ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print(MinWindowSubstring(new String[]{"abcaaaabbbbbbccccbbbbbaaaaa", "bca"}));
    }

}

//Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
//Output: aksfaje
//Input: new String[] {"aaffhkksemckelloe", "fhea"}
//Output: affhkkse