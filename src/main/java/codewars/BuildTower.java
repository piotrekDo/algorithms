package codewars;

import java.util.Arrays;

public class BuildTower {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(towerBuilder(3)));
        String[] strings = towerBuilder(3);
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println("------");
        System.out.println(Arrays.toString(towerBuilder2(3)));
        String[] strings2 = towerBuilder2(3);
        for (String string : strings2) {
            System.out.println(string);
        }
    }

//","
//"  *  "
//" *** "
// "*****"

    static String[] towerBuilder2(int nfloors) {
        String[] tower = new String[nfloors];
        String e;
        for (int i = 0; i < nfloors; i++)
            tower[i] = (e = " ".repeat(nfloors-i-1)) + "*".repeat(i+i+1) + e;
        return tower;
    }


    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        int base = nFloors == 1 ? 1 : nFloors * 2 - 1;
        int stars = 1;

        for (int i = 0; i < nFloors; i++) {
            StringBuilder sb = new StringBuilder();
            int spaces = (base - stars) / 2;
            sb.append("\"");
            for (int j = 0; j < spaces; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < stars; j++) {
                sb.append("*");
            }
            for (int j = 0; j < spaces; j++) {
                sb.append(" ");
            }
            sb.append("\"");
            tower[i] = sb.toString();

            stars += 2;
        }

        return tower;
    }

}
