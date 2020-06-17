package Leetcode.day10;

import java.util.HashMap;
import java.util.HashSet;

//  Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        int num = 0;
        while (true) {
            if (ptrA == ptrB) {
                return ptrA;
            }
            else {
                if (ptrA.next == null) {
                    ptrA = headB;
                    num++;
                    if (num == 2) {
                        return null;
                    }
                }
                else ptrA = ptrA.next;
                if (ptrB.next == null) {
                    ptrB = headA;
                }
                else ptrB = ptrB.next;
            }
        }
    }
}