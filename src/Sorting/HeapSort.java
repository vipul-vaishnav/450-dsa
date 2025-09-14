package Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 12, 4, 9, 11, 17};
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : arr) {
            pq.offer(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.poll();
        }
        return arr;
    }
}
