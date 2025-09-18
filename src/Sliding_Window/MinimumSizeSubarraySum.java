package Sliding_Window;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int l = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            while (currSum >= target) {
                len = Math.min(len, i - l + 1);
                currSum -= nums[l++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
