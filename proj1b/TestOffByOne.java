import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }

    @Test
    public void testIsPalindrome() {
        Palindrome palindrome = new Palindrome();
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("abcab", obo));
        assertFalse(palindrome.isPalindrome("aaa", obo));
        assertTrue(palindrome.isPalindrome("gdserch", obo));
        assertFalse(palindrome.isPalindrome("akz", obo));
        assertFalse(palindrome.isPalindrome("akfsdz", obo));
    }
}
