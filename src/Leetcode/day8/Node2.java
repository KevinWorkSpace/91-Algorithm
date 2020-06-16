//package Leetcode.day8;
//
//
//import java.util.LinkedList;
//
//// Definition for a Node.
//public class Node {
//    public int val;
//    public Node prev;
//    public Node next;
//    public Node child;
//};
//
//
//class Solution {
//    public Node flatten(Node head) {
//        LinkedList<Node> linkedList = new LinkedList();
//        if (head.child != null) {
//            flatten_dfs(head, head.child, linkedList);
//            return linkedList.get(0);
//        }
//        else if (head.next != null) {
//            flatten_dfs(head, head.next, linkedList);
//            return linkedList.get(0);
//        }
//        else {
//            return head;
//        }
//    }
//
//    public void flatten_dfs(Node prev, Node cur, LinkedList<Node> linkedList) {
//        if (cur == null) {
//            return;
//        }
//        linkedList.add(prev);
//        flatten_dfs(cur, cur.child, linkedList);
//        flatten_dfs(cur, cur.next, linkedList);
//    }
//}