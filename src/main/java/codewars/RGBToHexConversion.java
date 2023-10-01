package codewars;

public class RGBToHexConversion {
    public static void main(String[] args) {
        System.out.println(rgb(-87, 192, -55)); // returns 00C000
        System.out.println(rgb(254, 253, 252)); // returns FEFDFC
        System.out.println(rgb(-20, 275, 125)); // returns 00FF7D
        System.out.println(rgb(1, 2, 3)); // returns 010203
        System.out.println(rgb(255, 255, 255)); // returns FFFFFF
        System.out.println(rgb(255, 255, 300)); // returns FFFFFF
        System.out.println(rgb(0, 0, 0));       // returns 000000
        System.out.println(rgb(148, 0, 211));   // returns 9400D3
    }

    static String rgb(int r, int g, int b) {
        return getHex(r) + getHex(g) + getHex(b);
    }

    private static String getHex(int x) {
        if (x >= 255) return "FF";
        if (x < 0) return "00";
        if (x <= 9) return String.format("%02d", x);
        StringBuilder builder = new StringBuilder();
        do {
            double reminder = (double) x / 16;
            reminder = reminder >= 1 ? reminder % (int) reminder : reminder % 1;
            builder.append(getHexalValue((int) (reminder * 16)));
            x /= 16;
        } while (x > 0);

        return builder.reverse().toString();
    }

    private static String getHexalValue(int x) {
        return switch (x) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> String.valueOf(x);
        };
    }


    //    INNE PODEJSCIE Z KATA


    public static String rgb2(int r, int g, int b) {
        return ByteToHexString(r) + ByteToHexString(g) + ByteToHexString(b);
    }

    public static String ByteToHexString(int colorByte) {
        if (colorByte < 0) colorByte = 0;
        if (colorByte > 255) colorByte = 255;

        return digitToHexString(colorByte / 16) + digitToHexString(colorByte % 16);
    }

    public static String digitToHexString(int decimalDigit) {
        if (decimalDigit < 10) return String.valueOf(decimalDigit);
        else if (decimalDigit == 10) return "A";
        else if (decimalDigit == 11) return "B";
        else if (decimalDigit == 12) return "C";
        else if (decimalDigit == 13) return "D";
        else if (decimalDigit == 14) return "E";
        else return "F";
    }
}
