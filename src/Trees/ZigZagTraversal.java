package Trees;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        // int flag = 1;
        int level = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            // Deque<Integer> dq = new LinkedList<>();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = qu.poll();
                // if (flag == 1) dq.addLast(curr.val);
                // else dq.addFirst(curr.val);
                assert curr != null;
                li.add(curr.val);
                if (curr.left != null) qu.offer(curr.left);
                if (curr.right != null) qu.offer(curr.right);
            }
            // flag = -flag;
            // traversal.add(new ArrayList<>(dq));
            if (level % 2 != 0) {
                Collections.reverse(li);
            }
            level++;
            traversal.add(new ArrayList<>(li));
        }

        return traversal;
    }
}
