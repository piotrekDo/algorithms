package daily_coding_problem_mail;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    Palindrome palindrome = new Palindrome();


    @ParameterizedTest
    @ValueSource(strings = {"kayak", "deified", "Sit on a potato pan, Otis", "Murder for a jar of red rum.",
            "Yawn a more Roman way.", "aa"})
    void check_Palindrome_should_return_true(String text) {

        assertTrue(palindrome.checkPalindrome(text));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"nopee", "not a palindrome", "", "1"})
    void check_palindrome_should_return_false(String text) {

        assertFalse(palindrome.checkPalindrome(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"rcaacre", "ykakka", "ronam yaw. eroma wany", " " +
            "a more Roman Yawn way."})
    void check_rearranged_palindrome_should_return_true(String text) {

        assertTrue(palindrome.checkRearrangedPalindrome(text));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"nopee", "not a pailndrome", "a", ""})
    void check_rearranged_palindrome_should_return_false(String text) {

        assertFalse(palindrome.checkRearrangedPalindrome(text));
    }
}