package Matrix;

import java.util.ArrayList;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(spiralTraversal(matrix));
    }

    static ArrayList<Integer> spiralTraversal(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, down = rows - 1, left = 0, right = cols - 1;

        if (matrix.length == 0) return arr;

        while (top <= down && left <= right) {
            // left to right
            for (int k = left; k <= right; k++) {
                arr.add(matrix[top][k]);
            }
            top++;

            for (int k = top; k <= down; k++) {
                arr.add(matrix[k][right]);
            }
            right--;

            if (top <= down) {

                for (int k = right; k >= left; k--) {
                    arr.add(matrix[down][k]);
                }
                down--;
            }

            if (left <= right) {
                for (int k = down; k >= top; k--) {
                    arr.add(matrix[k][left]);
                }
                left++;
            }
        }

        return arr;
    }
}
