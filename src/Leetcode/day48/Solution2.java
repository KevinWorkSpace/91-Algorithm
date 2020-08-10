package Leetcode.day48;

class Solution2 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (pruneTree(root.left) == null) {
            root.left = null;
        }
        if (pruneTree(root.right) == null) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        else return root;
    }
}
