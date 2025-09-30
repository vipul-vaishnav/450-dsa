package Recursion;

public class PowerOf4 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(2));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(14));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n < 4) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
