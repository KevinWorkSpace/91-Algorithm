package Leetcode.day38;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode mNode = null;
        ListNode mNodePre = null;
        ListNode nNode = null;
        int count = 1;
        while (count <= n) {
            if (count == m) {
                mNode = cur;
                mNodePre = pre;
            }
            if (count < m) {
                pre = cur;
                cur = cur.next;
                count ++;
            }
            else {
                if (count == n) {
                    nNode = cur;
                }
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count ++;
            }
        }
        mNode.next = cur;
        if (mNodePre != null) {
            mNodePre.next = nNode;
        }
        else head = nNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution92 solution92 = new Solution92();
        solution92.reverseBetween(l1, 2, 4);
    }
}
