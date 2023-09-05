public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        if(x - y == 1 || y - x == 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPalindromeHelper(String word, int position) {
        int lastPosition = word.length() - 1 - position;
        if (position == lastPosition || position == lastPosition - 1) {
            return true;
        } else {
            if (equalChars(word.charAt(position), word.charAt(lastPosition))) {
                return isPalindromeHelper(word, position + 1);
            } else {
                return false;
            }
        }
    }

    public boolean isPalindrome(String word){
        return isPalindromeHelper(word, 0);
    }
}
