package Leetcode.day15;

class Solution2 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode treeNode, int num) {
        if (treeNode == null) return 0;
        int tmp = num * 10 + treeNode.val;
        if (treeNode.right == null && treeNode.left == null) {
            return tmp;
        }
        return helper(treeNode.right, tmp) + helper(treeNode.left, tmp);
    }
}