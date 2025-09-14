package Searching;

public class SearchInRotatedSortedArr {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int t1 = 0, t2 = 3;

        System.out.println(search(arr, t1));
        System.out.println(search(arr, t2));
    }

    static int search(int[] arr, int t) {
        int size = arr.length, low = 0, high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int el = arr[mid];

            if (el == t) return mid;

            if (el >= arr[low]) {
                // left sorted
                if (arr[low] <= t && t <= el) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right sorted
                if (el <= t && t <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
