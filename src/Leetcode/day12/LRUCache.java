package Leetcode.day12;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> hashMap;
    private MyLinkedList myLinkedList;
    private int capacity;

    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        myLinkedList = new MyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            int value = hashMap.get(key).value;
            put(key, value);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (hashMap.containsKey(key)) {
            myLinkedList.remove(hashMap.get(key));
        }
        else {
            if (myLinkedList.size == capacity) {
                Node node1 = myLinkedList.removeLast();
                hashMap.remove(node1.key);
            }
        }
        myLinkedList.addFirst(node);
        hashMap.put(key, node);
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        size ++;
    }

    public Node removeLast() {
        if (size != 0) {
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;
            size --;
            return last;
        }
        return null;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size --;
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
