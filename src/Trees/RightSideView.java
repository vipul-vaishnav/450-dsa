package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.TreeNode.createTree;

public class RightSideView {
    static int depth = -1;

    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = createTree(tree);
        System.out.println(rightSideView(root));

        System.out.println(rightSideDfsView(root));
    }

    static List<Integer> rightSideDfsView(TreeNode root) {
        depth = -1; // reset before second call;
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        dfs(root, 0, view);

        return view;
    }

    static void dfs(TreeNode root, int currDepth, List<Integer> view) {
        if (root == null) return;

        if (currDepth > depth) {
            depth = currDepth;
            view.add(root.val);
        }

        dfs(root.right, currDepth + 1, view);
        dfs(root.left, currDepth + 1, view);
    }

    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) {
            return view;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                assert node != null;
                if (i == size - 1) {
                    view.add(node.val);
                }
                if (node.left != null) qu.offer(node.left);
                if (node.right != null) qu.offer(node.right);
            }
        }

        return view;
    }
}
