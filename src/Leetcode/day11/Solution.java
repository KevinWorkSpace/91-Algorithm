package Leetcode.day11;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
}

public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        HashSet<ListNode> hashSet = new HashSet<>();
//        ListNode ptr = head;
//        while (ptr.next != null) {
//            if (hashSet.contains(ptr)) {
//                return ptr;
//            }
//            hashSet.add(ptr);
//            ptr = ptr.next;
//        }
//        return null;
//    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isCross = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCross = true;
                break;
            }
        }
        if (isCross) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        else return null;
    }
}
