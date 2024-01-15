package codewars;

public class BreakCamelCase {
//
//    "camelCasing"  =>  "camel Casing"
//            "identifier"   =>  "identifier"
//            ""             =>  ""

    public static void main(String[] args) {
        System.out.println(camelCase("AcamelCasing Lol"));
        System.out.println(camelCase2("AcamelCasing Lol"));
    }

    public static String camelCase(String input) {
        if (input.isBlank() || input.isEmpty()) return input;
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 65 && aChar <= 90) {
                result.append(" ");
            }
            result.append(aChar);
        }
        return result.toString().trim().replaceAll(" {2}", " ");
    }

    public static String camelCase2(String input) {
        return input.replaceAll("([A-Z])", " $1").replaceAll(" {2}", " ").trim();
    }
}
