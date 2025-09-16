package Strings;

public class CanBeTypedWords {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            boolean isValid = true;
            for (char ch : brokenLetters.toCharArray()) {
                if (word.indexOf(ch) != -1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) count++;
        }
        return count;
    }
}
