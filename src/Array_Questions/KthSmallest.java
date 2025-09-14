package Array_Questions;

import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
        System.out.println(kthLargest(arr, k));
    }

    static int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return (arr[k - 1]);
    }

    static int kthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}
