package Array_Questions;

import java.util.*;

public class UnionAndIntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 4, 1, 2};
        int[] arr2 = {3, 2, 4, 4, 5, 2, 2, 1};

        System.out.println(findUnion(arr1, arr2));
        System.out.println(findIntersection(arr1, arr2));
//        System.out.println(findUnion2(arr1, arr2));
    }

    static List<Integer> findUnion2(int[] arr1, int[] arr2) {
        Set<Integer> s = new HashSet<>();
        for (int num : arr1) {
            s.add(num);
        }
        for (int num : arr2) {
            s.add(num);
        }

        return new ArrayList<>(s);
    }

    static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != arr1[i]) {
                    res.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }

    static List<Integer> findUnion(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != arr1[i]) {
                    res.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != arr1[i]) {
                    res.add(arr1[i]);
                }
                i++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != arr2[j]) {
                    res.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < arr1.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != arr1[i]) {
                res.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != arr2[j]) {
                res.add(arr2[j]);
            }
            j++;
        }

        return res;
    }
}
