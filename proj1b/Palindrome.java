public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque res = new ArrayDeque();
        for (int i = word.length() - 1; i >= 0; i--) {
            res.addFirst(word.charAt(i));
        }
        return res;
    }

    private boolean isPalindromeHelper(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        } else {
            if (wordDeque.removeFirst() == wordDeque.removeLast()) {
                return isPalindromeHelper(wordDeque);
            } else {
                return false;
            }
        }
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }

    private boolean isPalindromeHelper(String word, int position, CharacterComparator cc) {
        int lastPosition = word.length() - 1 - position;
        if (position == lastPosition || position == lastPosition - 1) {
            return true;
        } else {
            if (cc.equalChars(word.charAt(position), word.charAt(lastPosition))) {
                return isPalindromeHelper(word, position + 1, cc);
            } else {
                return false;
            }
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(word, 0, cc);
    }
}
