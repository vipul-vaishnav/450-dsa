package Array_Questions;

public class SmallestSubArrWithSumGreaterThanX {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int x = 51;

        System.out.println(smallestSubWithSum(x, arr));
    }

    public static int smallestSubWithSum(int x, int[] arr) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int size = arr.length;
        int l = 0;

        for (int i = 0; i < size; i++) {
            sum += arr[i];

            while (sum > x) {
                int localLen = i - l + 1;
                len = Math.min(localLen, len);

                sum -= arr[l++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
