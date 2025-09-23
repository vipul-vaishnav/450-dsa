package Recursion;

public class PowerFunction {
    public static void main(String[] args) {
        double x = 34.050;
        int n = -3;

        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        return n < 0 ? 1.0 / helper(x, n) : helper(x, n);

    }

    public static double helper(double x, int n) {
        if (n == 0) return 1;
        double subProblem = helper(x, n / 2);
        if (n % 2 != 0) return x * subProblem * subProblem;
        return subProblem * subProblem;
    }
}
