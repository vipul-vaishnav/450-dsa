package Array_Questions;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {-2, -3, -1, -4};
        int[] arr2 = {1, -3, 2, 3, -4};

        System.out.println(maxSum(arr));
        System.out.println(maxSum(arr2));
        
        System.out.println(minSum(arr));
        System.out.println(minSum(arr2));
    }

    static int minSum(int[] arr) {
        int size = arr.length;
        int maxSum = arr[0];
        int currSum = arr[0];

        for (int i = 1; i < size; i++) {
            currSum = Math.min(arr[i], currSum + arr[i]);
            maxSum = Math.min(maxSum, currSum);
        }

        return maxSum;
    }

    static int maxSum(int[] arr) {
        int size = arr.length;
        int maxSum = arr[0];
        int currSum = arr[0];

        for (int i = 1; i < size; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
