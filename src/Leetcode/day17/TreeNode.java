package Leetcode.day17;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;  //根节点在中序遍历的位置
        for (int i=0; i<inorder.length; i++) {
            if (root.val == inorder[i]) {
                index = i;
                break;
            }
        }
        int[] subpreleft = new int[index];
        for (int j=0; j<subpreleft.length; j++) {
            subpreleft[j] = preorder[j+1];
        }
        int[] subpreright = new int[preorder.length-1-index];
        for (int j=0; j<subpreright.length; j++) {
            subpreright[j] = preorder[j+index+1];
        }

        int[] subinleft = new int[index];
        for (int j=0; j<subinleft.length; j++) {
            subinleft[j] = inorder[j];
        }
        int[] subinright = new int[inorder.length-1-index];
        for (int j=0; j<subinright.length; j++) {
            subinright[j] = inorder[j+index+1];
        }
        TreeNode leftRoot = buildTree(subpreleft, subinleft);
        TreeNode rightRoot = buildTree(subpreright, subinright);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        solution.buildTree(preorder, inorder);
    }
}
