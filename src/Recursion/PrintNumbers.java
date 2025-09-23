package Recursion;

import java.util.Arrays;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 5;
        int n2 = 10;

        System.out.println(Arrays.toString(print(n)));
        System.out.println(Arrays.toString(print(n2)));

        System.out.println(Arrays.toString(printRev(n)));
        System.out.println(Arrays.toString(printRev(n2)));
    }

    static int[] print(int n) {
        int[] res = new int[n + 1];
        helper(n, res);
        return res;
    }

    static int[] printRev(int n) {
        int[] res = new int[n + 1];
        helperRev(n, 0, res);
        return res;
    }

    static void helper(int n, int[] res) {
        if (n < 0) return;
        res[n] = n;
        helper(n - 1, res);
    }

    static void helperRev(int n, int idx, int[] res) {
        if (n < 0) return;
        res[idx] = n;
        helperRev(n - 1, idx + 1, res);
    }
}
