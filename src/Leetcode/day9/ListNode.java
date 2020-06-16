package Leetcode.day9;


 //Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public ListNode findMiddleNode(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMiddleNode(head);
        TreeNode middle = new TreeNode(mid.val);
        if (head == mid) {
            return middle;
        }
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(mid.next);
        middle.left = left;
        middle.right = right;
        return middle;
    }
}
