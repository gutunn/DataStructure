import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    Uncomment this class once you've created your Palindrome class. */
    static Palindrome palindrome = new Palindrome();
    static OffByOne offbyone = new OffByOne();

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
    public void testisPalindrome0() {
        boolean b = palindrome.isPalindrome("");
        assertTrue(b);
    }
    @Test
    public void testisPalindrome1() {
        boolean b = palindrome.isPalindrome("q");
        assertTrue(b);
    }
    @Test
    public void testisPalindromeTrue() {
        boolean b = palindrome.isPalindrome("radar");
        assertTrue(b);
    }
    @Test
    public void testisPalindromeFalse() {
        boolean b = palindrome.isPalindrome("radars");
        assertFalse(b);
    }
    @Test
    public void testisPalindromeOffByOne0() {
        boolean b = palindrome.isPalindrome("", offbyone);
        assertTrue(b);
    }
    @Test
    public void testisPalindromeOffByOne1() {
        boolean b = palindrome.isPalindrome("q", offbyone);
        assertTrue(b);
    }
    @Test
    public void testisPalindromeOffByOneTrue() {
        boolean b = palindrome.isPalindrome("radbq", offbyone);
        assertTrue(b);
    }
    @Test
    public void testisPalindromeOffByOneFalse() {
        boolean b = palindrome.isPalindrome("radar", offbyone);
        assertFalse(b);
    }
}
