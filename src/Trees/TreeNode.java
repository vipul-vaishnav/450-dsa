package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int _val) {
        this.val = _val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int _val, TreeNode _left, TreeNode _right) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
    }

    static TreeNode createTree(int[] arr) {
        if (arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int k = 1;
        while (k < arr.length) {
            TreeNode node = queue.poll();

            assert node != null;
            node.left = new TreeNode(arr[k++]);
            queue.offer(node.left);

            if (k < arr.length) {
                node.right = new TreeNode(arr[k++]);
                queue.offer(node.right);
            }
        }
        return root;
    }
}
