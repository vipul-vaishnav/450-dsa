package Recursion;

public class PowerOf3 {
    public static void main(String[] args) {
        int num = 349275;
        System.out.println(isPowerOfThree(num));
        System.out.println(isPowerOfThree(27));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
//        if (n == 1) return true;
//        if (n < 3) return false;
//        if (reduce(n) % 3 != 0) return false;
//        return isPowerOfThree(n / 3);
    }

    public static int reduce(int num) {
        if (num <= 9) return num;
        int sum = 0;
        while (num != 0) {
            int dig = num % 10;
            num = num / 10;
            sum += dig;
        }
        if (sum <= 9) return sum;
        return reduce(sum);
    }
}

