package Trees;

public class KthSmallestInBST {
    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        count++;
        if (count == k) {
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }

    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> inorder = new ArrayList<>();
    //     dfs(root, inorder);
    //     return inorder.get(k - 1);
    // }

    // void dfs(TreeNode root, List<Integer> inorder) {
    //     if (root == null) return;
    //     dfs(root.left, inorder);
    //     inorder.add(root.val);
    //     dfs(root.right, inorder);
    // }
}
