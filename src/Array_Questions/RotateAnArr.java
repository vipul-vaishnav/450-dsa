package Array_Questions;

import java.util.Arrays;

public class RotateAnArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        int k2 = 3;
        int k3 = 5;
        int k4 = 47;

        rightRotateByK(arr, k4 % arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }

    static void leftRotateByK(int[] arr, int k) {
        // segment reverse k, n - k
        // whole reverse

        if (k == 0) return;

        int size = arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, size - 1);
        reverse(arr, 0, size - 1);
    }

    static void rightRotateByK(int[] arr, int k) {
        // whole reverse
        // segment reverse k, n - k
        if (k == 0) return;
        
        int size = arr.length;
        reverse(arr, 0, size - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, size - 1);
    }
}
