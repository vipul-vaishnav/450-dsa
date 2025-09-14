package Array_Questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(maxOfSubarray(arr, k));
    }

    static ArrayList<Integer> maxOfSubarray(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // 1. Remove indices out of this window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Maintain decreasing order in deque
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Record the maximum once window is full
            if (i >= k - 1) {
                res.add(arr[dq.peekFirst()]);
            }
        }

        return res;
    }
}
