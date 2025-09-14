package Array_Questions;

public class DivideArrInTwoSubArraysOfEqualSum {
    public static void main(String[] args) {
        int[] arr = {3, 4, -2, 5, 8, 20, -10, 8};

        System.out.println(isPossible(arr));

    }

    static boolean isPossible(int[] arr) {
        int total = 0;
        for (int x : arr) total += x;

        int leftSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {  // stop at n-2 so right side isn’t empty
            leftSum += arr[i];
            int rightSum = total - leftSum;
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    static int findPivot(int[] arr) {
        int size = arr.length;
        int[] prefixSum = new int[size];

        for (int i = 0; i < size; i++) {
            if (i == 0) prefixSum[i] = arr[i];
            else prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < size; i++) {
            int leftSum = i == 0 ? 0 : prefixSum[i - 1];
            int rightSum = prefixSum[size - 1] - prefixSum[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
