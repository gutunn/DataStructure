import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestOffByOneTrue1() {
        assertTrue(offByOne.equalChars('a', 'b'));
    }
    @Test
    public void TestOffByOneTrue2() {
        assertTrue(offByOne.equalChars('b', 'a'));
    }
    @Test
    public void TestOffByOneFalse1() {
        assertFalse(offByOne.equalChars('a', 'a'));
    }
    @Test
    public void TestOffByOneFalse2() {
        assertFalse(offByOne.equalChars('a', 'c'));
    }
}
