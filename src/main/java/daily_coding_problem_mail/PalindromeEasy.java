package daily_coding_problem_mail;


import java.util.HashMap;

public class PalindromeEasy {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        boolean isRearrangedPalindrome = palindrome.checkRearrangedPalindrome("a more Roman Yawn way.");
        System.out.println(isRearrangedPalindrome);

        System.out.println();
        boolean isRearrangedPalindrome2 = palindrome.checkRearrangedPalindrome("Yawn a more Roman way.");
        System.out.println(isRearrangedPalindrome2);

    }
}

class Palindrome {

    boolean checkPalindrome(String text) {
        if (text == null || text.length() < 2){
            return false;
        }
        text = text.replaceAll("\\W", "").toLowerCase();
        int index = 0;
        char[] chars = text.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != text.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    boolean checkRearrangedPalindrome(String text) {
        if (text == null || text.length() < 2){
            return false;
        }
        text = text.replaceAll("\\W", "").toLowerCase();
        char[] chars = text.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            Integer val = map.getOrDefault(c, 0) + 1;
            map.put(c, val);
        }

        long count = map.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .count();

        return count < 2;
    }

}
