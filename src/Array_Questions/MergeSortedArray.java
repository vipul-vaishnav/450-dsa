package Array_Questions;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int e = m - 1;
        for (int i = 0; i < n; i++) {
            int el = nums2[i];
            int pos = searchInsertPosition(el, nums1, e);
            e++;
            insertEl(nums1, el, pos, e);
        }
    }

    private void insertEl(int[] arr, int el, int pos, int end) {
        for (int i = end; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = el;
    }

    private int searchInsertPosition(int el, int[] arr, int end) {
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midEl = arr[mid];
            if (el > midEl) {
                start = mid + 1;
            } else if (el < midEl) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
