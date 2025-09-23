package Array_Questions;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {2, 3, -1, 8, 4};
        System.out.println(pivotIndex(nums));
    }

    static int pivotIndex(int[] nums) {
        int size = nums.length;
        int[] prefixSum = new int[size];
        for (int i = 0; i < size; i++) {
            prefixSum[i] = i == 0 ? nums[i] : nums[i] + prefixSum[i - 1];
        }
        for (int i = 0; i < size; i++) {
            int ls = i == 0 ? 0 : prefixSum[i - 1];
            int rs = i == size - 1 ? 0 : prefixSum[size - 1] - prefixSum[i];
            if (ls == rs) return i;
        }
        return -1;
    }
}
