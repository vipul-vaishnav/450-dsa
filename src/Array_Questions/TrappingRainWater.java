package Array_Questions;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {3, 0, 1, 0, 4, 0, 2};
        System.out.println(maxWater(heights));
    }

    static int maxWater(int[] arr) {
        int size = arr.length;

        int[] leftMax = getLeftMax(arr);
        int[] rightMax = getRightMax(arr);

        int sum = 0;
        for (int i = 0; i < size; i++) {
            int h = arr[i];
            sum += Math.min(leftMax[i], rightMax[i]) - h;
        }
        return sum;
    }

    static int[] getLeftMax(int[] arr) {
        int[] heights = new int[arr.length];
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) {
                heights[i] = arr[i];
            } else {
                heights[i] = Math.max(arr[i], heights[i - 1]);
            }
        }
        return heights;
    }

    static int[] getRightMax(int[] arr) {
        int[] heights = new int[arr.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            if (i == heights.length - 1) {
                heights[i] = arr[i];
            } else {
                heights[i] = Math.max(arr[i], heights[i + 1]);
            }
        }
        return heights;
    }
}
