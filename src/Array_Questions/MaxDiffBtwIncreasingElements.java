package Array_Questions;

public class MaxDiffBtwIncreasingElements {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 4};
        System.out.println(maximumDifference(arr));
    }

    static public int maximumDifference(int[] nums) {
        int diff = Integer.MIN_VALUE;

        int[] rMax = getRightMax(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int r = rMax[i + 1];
            if (r > nums[i]) {
                diff = Math.max(diff, r - nums[i]);
            }
        }

        return diff == Integer.MIN_VALUE ? -1 : diff;
    }

    static int[] getRightMax(int[] arr) {
        int size = arr.length;
        int[] res = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            if (i == size - 1) res[i] = arr[i];
            else res[i] = Math.max(arr[i], res[i + 1]);
        }

        return res;
    }
}
