import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("ab"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("ababba"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("aaccbbbccaa"));
        assertFalse(palindrome.isPalindrome("za"));
    }

    @Test
    public void testIsOffByOnePalindrome() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("aba", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
    }
}
