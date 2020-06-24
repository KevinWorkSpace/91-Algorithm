package Leetcode.day13;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
}
