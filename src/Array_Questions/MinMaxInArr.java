package Array_Questions;

import java.util.Arrays;

public class MinMaxInArr {
    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 16, 22, 19};
        System.out.println(Arrays.toString(minMax(arr)));
    }

    static int[] minMax(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[0], arr[arr.length - 1]};
    }
}
