package Leetcode.day18;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int tmpSum = root.val + leftGain + rightGain;
        if (tmpSum > max) max = tmpSum;
        return root.val + Math.max(leftGain, rightGain);
    }
}
