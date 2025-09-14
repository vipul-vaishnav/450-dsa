package Strings;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abba";
        String str2 = "leetcode";
        String str3 = " ";

        System.out.println(findLen(str));
        System.out.println(findLen(str2));
        System.out.println(findLen(str3));
    }
    
    static int findLen(String str) {
        int size = str.length();
        int maxLen = 0;
        int l = 0;
        int[] freq = new int[128];
        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            freq[ch]++;

            while (freq[ch] > 1) {
                freq[str.charAt(l)]--;
                l++;
            }

            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
