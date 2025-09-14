package Array_Questions;

import java.util.Arrays;

public class ReverseArr {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
