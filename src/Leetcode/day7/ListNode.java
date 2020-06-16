package Leetcode.day7;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode cur = head;
//        ListNode pre = null;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode prev = l1;
        for (int i=0; i<4; i++) {
            ListNode listNode = new ListNode(i+2);
            prev.next = listNode;
            prev = listNode;
        }
        Solution solution = new Solution();
        System.out.println(solution.reverseList(l1).val);
    }
}

