package Recursion;

public class CheckArrSorted {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 5, 6, 6, 6, 7, 8};
        int[] arr2 = {2, 3, 4, 4, 6, 1, 7, 8, 4};

        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr2));
    }

    private static boolean isSorted(int[] arr) {
        return helper(arr, 0);
    }

    private static boolean helper(int[] arr, int i) {
        int size = arr.length;
        if (i == size - 1) return true;
        return arr[i] <= arr[i + 1] && helper(arr, i + 1);
    }

}
