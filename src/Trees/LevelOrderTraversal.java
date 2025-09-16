package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while (!qu.isEmpty()) {
            List<Integer> comp = new ArrayList<>();

            int size = qu.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = qu.poll();
                if (curr != null) {
                    comp.add(curr.val);
                    if (curr.left != null) qu.offer(curr.left);
                    if (curr.right != null) qu.offer(curr.right);
                }
            }

            res.add(comp);
        }

        return res;
    }
}
