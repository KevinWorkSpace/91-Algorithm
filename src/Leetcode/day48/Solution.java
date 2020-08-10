package Leetcode.day48;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (hasOne(root)) return root;
        else return null;
    }

    public boolean hasOne(TreeNode node) {
        if (node == null) return false;

        if (!hasOne(node.left)) {
            node.left = null;
        }
        if (!hasOne(node.right)) {
            node.right = null;
        }
        return (node.val == 1) || (node.left != null) || (node.right != null);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(1);
        t1.right = t2;
        t2.left = t3;
        t3.right = t4;
        Solution solution = new Solution();
        solution.pruneTree(t1);
    }
}
