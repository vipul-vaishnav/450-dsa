package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 7, 11};
        int target = 9;
        int target2 = 14;

        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSum(arr, target2)));
    }

    static int[] twoSum(int[] arr, int target) {
        int[] res = {-1, -1};
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int comp = target - num;

            if (mpp.containsKey(comp)) {
                int idx1 = mpp.get(comp);
                res[0] = idx1;
                res[1] = i;
                break;
            } else {
                mpp.put(num, i);
            }
        }

        return res;
    }
}
