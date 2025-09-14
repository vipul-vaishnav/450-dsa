package Array_Questions;

import java.util.Arrays;

public class MoveNegativesToFront {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        move(arr);
//        move2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void move2(int[] arr) {
    }

    static void move(int[] arr) {
        int size = arr.length, l = 0, r = size - 1;

        while (l < r) {
            while (l < r && arr[l] < 0) l++;
            while (l < r && arr[r] >= 0) r--;

            if (r > l) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
}
