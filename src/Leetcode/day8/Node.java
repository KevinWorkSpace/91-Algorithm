package Leetcode.day8;


// Definition for a Node.
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node pseudoHead = new Node();
        pseudoHead.val = 0;
        pseudoHead.prev = null;
        pseudoHead.next = head;
        pseudoHead.child = null;

        flatten_dfs(pseudoHead, head);

        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public Node flatten_dfs(Node prev, Node cur) {
        if (cur == null) {
            return prev;
        }
        Node next = cur.next;
        prev.next = cur;
        cur.prev = prev;

        Node tail = flatten_dfs(cur, cur.child);
        prev.child = null;
        return flatten_dfs(tail, next);
    }
}