package Searching;

import java.util.ArrayList;

public class FirstAndLastPos {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125}; // 0- 8
        int x = 5;

        System.out.println(find(arr, x));
    }

    static ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(findFirst(arr, x));
        res.add(findLast(arr, x));
        return res;
    }

    static int findLast(int[] arr, int x) {
        int size = arr.length;
        int low = 0, high = size - 1;

        while (high - low > 1) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] == x) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        if (arr[high] == x) {
            return high;
        } else if (arr[low] == x) {
            return low;
        } else {
            return -1;
        }
    }

    static int findFirst(int[] arr, int x) {
        int size = arr.length;
        int low = 0, high = size - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                high = mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return arr[low] == x ? low : -1;
    }

}
