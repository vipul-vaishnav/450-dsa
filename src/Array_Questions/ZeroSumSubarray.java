package Array_Questions;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 5, 2, -3, -6, 1, 6};

        System.out.println(getZeroSumSubarrayLen(arr));
        System.out.println(getZeroSumSubarrayMaxLen(arr));
    }

    static int getZeroSumSubarrayMaxLen(int[] arr) {
        int len = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (mpp.containsKey(sum)) {
                len = Math.max(len, i - mpp.get(sum));
            } else {
                mpp.put(sum, i);
            }
        }
        return len;
    }

    // first one okay
    static int getZeroSumSubarrayLen(int[] arr) {
        int len = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (mpp.containsKey(sum)) {
                return i - mpp.get(sum);
            } else {
                mpp.put(sum, i);
            }
        }
        return len;
    }
}
