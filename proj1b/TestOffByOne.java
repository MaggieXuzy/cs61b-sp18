import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }

    @Test
    public void testIsPalindrome() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.isPalindrome("abcab"));
        assertFalse(obo.isPalindrome("aaa"));
        assertTrue(obo.isPalindrome("gdserch"));
        assertFalse(obo.isPalindrome("akz"));
        assertFalse(obo.isPalindrome("akfsdz"));
    }
}
