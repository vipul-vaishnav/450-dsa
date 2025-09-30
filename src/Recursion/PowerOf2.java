package Recursion;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(11));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1 || n == 2) return true;
        if ((n & 1) == 1) return false;
        return isPowerOfTwo(n / 2);
        // if (n <= 0) return false;
        // return (n & (n - 1)) == 0;
    }
}
