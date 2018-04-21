package lt.rp.ltt.ltTest.basics.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * is palindrome methods unit tests
 * 
 * @author rpajares 
 */
public class PalindromeTest {

    @Test
    public void testIsPalindrome() throws Exception {
        assertTrue(Palindrome.isPalindromeMethodOne("1221"));
    }

    @Test
    public void testIsNotPalindrome() throws Exception {
        assertFalse(Palindrome.isPalindromeMethodOne("not palindrome"));
    }

    @Test
    public void testIsNotPalindromeNullValue() throws Exception {
        assertFalse(Palindrome.isPalindromeMethodOne(null));
    }
}