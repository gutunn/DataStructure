public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque D = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            D.addLast(word.charAt(i));
        }
        return D;
    }
    //implement isPalindrome without Deque.

    public boolean isPalindrome(String word) {
        for (int i = 0; i < (word.length() / 2); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        OffByOne o = new OffByOne();
        for (int i = 0; i < (word.length() / 2); i++) {
            if (i == (word.length() / 2) + 1) {
                return true;
            }
            if (!o.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }


    // implement isPalindrome with Deque.(false)
    /*public boolean isPalindrome(String word) {
        Palindrome p = new Palindrome();
        Deque D =p.wordToDeque(word);
        for (int i = 0; i <= (word.length() / 2); i++) {
            if (D.removeFirst() != D.removeLast()) {
                return false;
            }
            if (D.removeLast() == null) {
                return true;
            }
        }
        return true;
    } */

    // implement isPalindrome with Deque iteratively.
    public boolean isPalindrome2(String word) {
        Palindrome p = new Palindrome();
        Deque D = p.wordToDeque(word);
        Deque D2 = p.wordToDeque(word);
        for (int i = 0; i < (word.length() / 2); i++) {
            if (D.removeFirst() != D2.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
