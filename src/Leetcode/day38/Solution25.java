package Leetcode.day38;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            ListNode next = cur.next;
            if (i % k == 0) {
                head = reverseBetween(head, i-k+1, i);
            }
            cur = next;
            i++;
        }
        return head;
    }

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
}
