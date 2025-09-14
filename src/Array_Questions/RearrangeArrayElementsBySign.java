package Array_Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; // 5, -5, 2, -2, 4, -8, 7, 1, 8, 0

//        rearrange(arr);
        rearrange2(arr); // order is not preserved

        System.out.println(Arrays.toString(arr));
    }

    static void rearrange2(int[] arr) {
        // partition
        int size = arr.length, l = 0, r = size - 1;

        while (l < r) {
            while (l < r && arr[l] < 0) l++;
            while (l < r && arr[r] >= 0) r--;

            if (l < r) {
                int temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }

        int neg = 0, pos = l;

        while (neg < pos && pos < size) {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            neg += 2;
            pos++;
        }
    }

    static void rearrange(int[] arr) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for (int num : arr) {
            if (num >= 0) pos.offer(num);
            else neg.offer(num);
        }

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (pos.isEmpty() && !neg.isEmpty()) {
                    arr[i] = neg.poll();
                } else {
                    arr[i] = pos.poll();
                }
            } else {
                if (neg.isEmpty() && !pos.isEmpty()) {
                    arr[i] = pos.poll();
                } else {
                    arr[i] = neg.poll();
                }
            }
        }
    }
}

//static void rearrange2(ArrayList<Integer> arr) {
//    int size = arr.size(), l = 0, r = size - 1;
//
//    // Partition step
//    while (l < r) {
//        while (l < r && arr.get(l) < 0) l++;
//        while (l < r && arr.get(r) >= 0) r--;
//
//        if (l < r) {
//            int temp = arr.get(l);
//            arr.set(l, arr.get(r));
//            arr.set(r, temp);
//            l++;
//            r--;
//        }
//    }
//
//    int neg = 0, pos = l;
//
//    // Rearrange step
//    while (neg < pos && pos < size) {
//        int temp = arr.get(neg);
//        arr.set(neg, arr.get(pos));
//        arr.set(pos, temp);
//        neg += 2;
//        pos++;
//    }
//}