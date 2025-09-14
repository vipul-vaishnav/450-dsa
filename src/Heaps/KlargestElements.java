package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KlargestElements {
    public static void main(String[] args) {
        int[] arr = {22, 23, 141, 786, 102, 1096, 866, 34, 566};
        int k = 3;

        System.out.println(kLargest(arr, k));
    }

    static ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int a : arr) {
            pq.offer(a);
            while (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> t = new ArrayList<>();
        while (!pq.isEmpty()) {
            t.add(pq.poll());
        }

        Collections.reverse(t);
        return t;
    }

}
