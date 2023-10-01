package codewars;

import java.util.ArrayList;
import java.util.List;

public class RectangleIntoSquares {
    public static void main(String[] args) {
        System.out.println(sqInRect(5, 3)); //powinno da 3 2 1 1
    }

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth)
            return null;
        ArrayList<Integer> result = new ArrayList<>();

        int shortest = 1;

        while (shortest > 0) {
            if (lng < wdth) {
                shortest = lng;
                wdth -= lng;
            } else {
                shortest = wdth;
                lng -= wdth;
            }
            if (shortest > 0)
                result.add(shortest);
        }
        return result;
    }
}
