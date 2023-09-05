public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if(x - y == 1 || y - x == 1) {
            return true;
        }
        return false;
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
