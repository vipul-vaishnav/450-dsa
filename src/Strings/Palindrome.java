package Strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abba";
        String str2 = "lamuumal";
        String str3 = "vipuupl";

        System.out.println(isPal(str));
        System.out.println(isPal(str2));
        System.out.println(isPal(str3));

        System.out.println(checkPalindrome("N2 i&nJA?a& jnI2n"));
    }

    static boolean checkPalindrome(String str) {
        StringBuilder s = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                s.append(Character.toLowerCase(ch));
            } else if (Character.isDigit(ch)) {
                s.append(ch);
            }
        }
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    static boolean isPal(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
