package Leetcode.day15;

import java.util.HashMap;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode treeNode, int num) {
        if (treeNode == null) {
            return num;
        }
        else {
            int tmp = num * 10 + treeNode.val;
            int left = 0;
            int right = 0;
            if (treeNode.left != null) {
                left = helper(treeNode.left, tmp);
            }
            if (treeNode.right != null) {
                right = helper(treeNode.right, tmp);
            }
            if (left + right == 0) {
                return tmp;
            }
            return left + right;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        Solution solution = new Solution();
        int result = solution.sumNumbers(t1);
    }
}
