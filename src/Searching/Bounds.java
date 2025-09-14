package Searching;

public class Bounds {
    public static void main(String[] args) {
        // LOWER BOUND
        // first element >= x

        int[] arr = {3, 3, 5, 5, 6, 7, 8, 8, 8};

        System.out.println(lb(arr, 4));
        System.out.println(lb(arr, 1));
        System.out.println(lb(arr, 9));

        // UPPER BOUND
        // first element > x

        System.out.println(up(arr, 5));
        System.out.println(up(arr, 1));
        System.out.println(up(arr, 9));
    }

    static int lb(int[] arr, int k) {
        int size = arr.length;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i] < k ? 0 : 1;
        }

        // here we need first truthy value i.e first idx of 1

        int low = 0, high = size;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (temp[mid] == 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }


        return low;
    }

    static int up(int[] arr, int k) {
        int size = arr.length;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i] <= k ? 0 : 1;
        }

        // here we need first truthy value i.e first idx of 1

        int low = 0, high = size;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (temp[mid] == 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
